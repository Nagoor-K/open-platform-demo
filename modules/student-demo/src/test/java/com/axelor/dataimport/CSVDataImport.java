package com.axelor.dataimport;

import java.io.IOException;

import org.junit.Test;

import com.axelor.data.Importer;
import com.axelor.data.csv.CSVImporter;
import com.axelor.inject.Beans;
import com.axelor.student.db.repo.ProjectRepository;

public class CSVDataImport {
	
	@Test
	public void deaulttest() throws IOException{
		
		Importer importer=new CSVImporter("data-init/input-config.xml","data-init/csv");
		//importer.run();
		System.err.println(Beans.get(ProjectRepository.class).all().fetch());
	}
}
