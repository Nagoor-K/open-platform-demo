package com.axelor.student.db.events;

import com.axelor.student.db.Student;

public class StudentSaved {
	
	private final Student student;
	
	public StudentSaved(Student student) {
		this.student=student;
	}
	
	public Student getStudent() {
		return student;
	}
	
}
