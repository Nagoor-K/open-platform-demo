package com.axelor.student.db.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axelor.student.db.Student;
import com.axelor.student.db.service.StudentService;

public class StudentServiceImpl implements StudentService {

	protected Logger log = LoggerFactory.getLogger(getClass());
	
	
  @Override
  public String say(Student student) {
	  return String.format("Welcome, '%s!'",student.getName() );
  }

  @Override
  public String hello() {
	  
    return "Hello, Nagoor Khan";
  }
	
}
