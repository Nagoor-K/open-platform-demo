package com.axelor.student.db.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.axelor.student.db.Student;
import com.axelor.student.db.repo.StudentRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

@Path("/student")
public class StudentService {
	
	@Inject
	StudentRepository studentRepos;
	JsonNodeFactory factory= JsonNodeFactory.instance;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonNode getallstudents() {
		ObjectNode mainNode=factory.objectNode();
		List<Student> students=studentRepos.all().fetch();
		
		ArrayNode arrayNode=factory.arrayNode();
		for(Student s:students) {
			ObjectNode studentNode=factory.objectNode();
			studentNode.put("fullname", s.getName());
			studentNode.putPOJO("0", arrayNode);
			arrayNode.add(studentNode);
		}
		mainNode.put("status",0);
		mainNode.set("data", arrayNode);
		return mainNode;
	}
}
