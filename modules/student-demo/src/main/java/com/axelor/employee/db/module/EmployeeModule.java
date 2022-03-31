package com.axelor.employee.db.module;

import com.axelor.app.AxelorModule;
import com.axelor.employee.db.service.EmployeeService;
import com.axelor.employee.db.service.EmployeeServiceImpl;
import com.axelor.student.db.Project;
import com.axelor.student.db.repo.ProjectRepository;

public class EmployeeModule extends AxelorModule{
	
	@Override
	  protected void configure() {
	   bind(EmployeeService.class).to(EmployeeServiceImpl.class);
	   bind(ProjectRepository.class);
	  }
}
