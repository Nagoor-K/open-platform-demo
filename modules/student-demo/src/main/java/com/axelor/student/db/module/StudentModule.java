package com.axelor.student.db.module;

import com.axelor.app.AxelorModule;
import com.axelor.student.db.service.StudentService;
import com.axelor.student.db.serviceimpl.StudentServiceImpl;

public class StudentModule extends AxelorModule {
	@Override
	  protected void configure() {
	    bind(StudentService.class).to(StudentServiceImpl.class);
	  }
}
