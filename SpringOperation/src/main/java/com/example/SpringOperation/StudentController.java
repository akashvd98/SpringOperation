package com.example.SpringOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	public StudentService studentService;
	
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/studentSave")
	public String insertStudent(@RequestBody Student student){
		studentRepo.save(student);
		return "Student Data Inserted.....!!";
		
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getStudent(){
		return (List<Student>) studentRepo.findAll();
	}
	
	@GetMapping("/getStudentName/{name}")
	public List<Student> getName(@PathVariable("name")String sname) {
		return (List<Student>) studentRepo.findByName(sname);
	}
	
	@GetMapping("/getStudentId/{id}")
	public List<Student> getId(@PathVariable("id")long id) {
	    if(id!=id) {
	    	throw new ExceptionDemo("Please Enter Valid Id");
	    }
		return (List<Student>) studentRepo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void updateStudent(@PathVariable long id) {
		if(id!=id) {
	    	throw new ExceptionDemo("Please Enter Valid Id");
	    }
		studentRepo.deleteStudentById(id);
	}
	
	@DeleteMapping("/delete/{name}")
	public void updateStudent(@PathVariable String name) {
		studentRepo.deleteStudentByName(name);
	}
	
	@GetMapping("/updateStudent")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
 }
