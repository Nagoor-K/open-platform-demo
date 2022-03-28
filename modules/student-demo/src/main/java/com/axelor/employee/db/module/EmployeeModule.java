package com.axelor.employee.db.module;

import com.axelor.app.AxelorModule;
import com.axelor.employee.db.service.EmployeeService;
import com.axelor.employee.db.service.EmployeeServiceImpl;

public class EmployeeModule extends AxelorModule{
	
	@Override
	  protected void configure() {
	   bind(EmployeeService.class).to(EmployeeServiceImpl.class);
	  }
}
