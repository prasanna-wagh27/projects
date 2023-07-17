package com.sbproject.sms.service;

import java.util.List;

import com.sbproject.sms.enity.Student;

public interface StudentService{

	List<Student> getAllStudents();

	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	Student findStudentById(Long id);

	void deleteStudentById(Long id);

	Student findStudentById(String firstname);

}
