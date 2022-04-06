package com.axelor.student.db.service;

import com.axelor.event.Event;
import com.axelor.student.db.Student;
import com.axelor.student.db.events.StudentSaved;
import com.google.inject.Inject;

public class StudentServe {
	
	@Inject
	private Event<StudentSaved> studentSavedEvent;
	
	public void fireStudentSavedEvent(Student student) {
		studentSavedEvent.fire(new StudentSaved(student));
	}
}
