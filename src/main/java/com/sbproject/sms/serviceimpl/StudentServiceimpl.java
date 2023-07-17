package com.sbproject.sms.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbproject.sms.enity.Student;
import com.sbproject.sms.repository.StudentRepository;
import com.sbproject.sms.service.StudentService;
@Service
public class StudentServiceimpl implements StudentService{

	
	private StudentRepository studentRepository;

	public StudentServiceimpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student findStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student findStudentById(String firstName) {
		
		return studentRepository.findByFirstName(firstName);
	}
}
