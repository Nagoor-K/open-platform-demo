package com.axelor.student.db.controllers;

import com.axelor.meta.CallMethod;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Response;
import com.axelor.student.db.Student;
import com.axelor.student.db.service.StudentService;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class StudentController {
	
	@Inject
	private StudentService service;
	
	public void say(ActionRequest request, ActionResponse response) {
		
		Student student=request.getContext().asType(Student.class);
		
		String mesg=service.say(student);
		response.setFlash(mesg);
	}
	
	@CallMethod
	public Response validate(int classno) {
		
		Response response=new ActionResponse();
		if(classno>10)
			response.addError("classno", "Class Number is Required");
		return response;
		
	}
	public Response validateRommno(int roomno) {
		Response response=new ActionResponse();
		if(roomno>23)
			response.addError("roomno","Room NUmber can not be greater than 23");
		return response;
	}
	
}
