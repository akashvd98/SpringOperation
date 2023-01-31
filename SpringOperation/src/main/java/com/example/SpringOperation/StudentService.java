package com.example.SpringOperation;

public class StudentService {
	
	public StudentRepo studentRepo;
	
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	

}
