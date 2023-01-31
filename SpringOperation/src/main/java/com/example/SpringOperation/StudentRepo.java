package com.example.SpringOperation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
public List<Student> findByName(String name);
	
	public List<Student> findById(long id);
	
	public void deleteStudent(long id);
	
	public void deleteStudentById(long id);
	
	public void deleteStudentByName(String name);
	
	public void addStudent(Student student);

}
