package com.axelor.employee.db.web;

import com.axelor.employee.db.Employee;
import com.axelor.employee.db.repo.EmployeeRepository;
import com.axelor.employee.db.service.EmployeeService;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class EmployeeController {
	
	public void sayMethod(ActionRequest request,ActionResponse response) {
		
		Context context=request.getContext();
		Employee emp=context.asType(Employee.class);
		
		System.err.println(emp);
		
		if(emp.getId() !=null) {
			emp=Beans.get(EmployeeRepository.class).find(emp.getId());
		}
		
		System.err.println(emp);
		
		Beans.get(EmployeeService.class).validateSalary(emp);
		response.setError("Changing the value");
	}
}
