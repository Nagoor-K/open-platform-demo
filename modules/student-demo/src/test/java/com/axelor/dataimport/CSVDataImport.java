package com.axelor.dataimport;

import java.io.IOException;

import org.junit.Test;

import com.axelor.data.Importer;
import com.axelor.data.csv.CSVImporter;
import com.axelor.employee.db.module.EmployeeModule;
import com.axelor.inject.Beans;
import com.axelor.student.db.repo.ProjectRepository;
import com.axelor.test.GuiceModules;
@GuiceModules(EmployeeModule.class)
public class CSVDataImport {
	
	@Test
	public void deaulttest() throws IOException{
		
		Importer importer=new CSVImporter("data-init/input-config.xml","data-init/csv");
		importer.run();
	}
}
