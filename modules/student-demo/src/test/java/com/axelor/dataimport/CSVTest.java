package com.axelor.dataimport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axelor.data.ImportException;
import com.axelor.data.ImportTask;
import com.axelor.data.Importer;
import com.axelor.data.Listener;
import com.axelor.data.csv.CSVImporter;
import com.axelor.db.Model;
import com.axelor.employee.db.module.EmployeeModule;
import com.axelor.test.GuiceModules;
import com.axelor.test.GuiceRunner;
import com.google.inject.Injector;

@RunWith(GuiceRunner.class)
@GuiceModules(EmployeeModule.class)
public class CSVTest {

  private Logger log = LoggerFactory.getLogger(getClass());

  @Inject 
  private Injector injector;

  @Test
  public void testCsv() throws ClassNotFoundException {

    final Importer importer = new CSVImporter("/data-init/input-config.xml"); 

    final List<Model> records = new ArrayList<>();
    final Map<String, Object> context = new HashMap<>();

    //context.put("CUSTOMER_PHONE", "+3326253225");

    importer.addListener(new Listener() { 
      @Override
      public void imported(Model bean) {
        log.info("Bean saved : {}(id={})",
            bean.getClass().getSimpleName(),
            bean.getId());
        records.add(bean);
      }

      @Override
      public void imported(Integer total, Integer success) {
        log.info("Record (total): " + total);
        log.info("Record (success): " + success);
      }

      @Override
      public void handle(Model bean, Exception e) {

      }
    });

    importer.run(new ImportTask() { 

      @Override
      public void configure() throws IOException {
        // provide input data
        input("titles", new File("title.csv")); 
        input("title-update", new File("title-updata.csv"));
      }

      @Override
      public boolean handle(ImportException exception) { 
        log.error("Import error : " + exception);
        return false;
      }

      @Override
      public boolean handle(IOException e) { 
        log.error("IOException error : " + e);
        return true;
      }
    });
  }
}