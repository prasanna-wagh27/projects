package com.sbproject.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sbproject.sms.enity.Student;
import com.sbproject.sms.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String addStudent(Model model) {
		
		Student student= new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
	    model.addAttribute("student", studentservice.findStudentById(id));
	    return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
	    studentservice.updateStudent(student);
	    return "redirect:/students";
	}

	@PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentservice.deleteStudentById(id);
        return "redirect:/students";
    }
	
	@GetMapping("/students/{firstName}")
	public String findStudentById(@PathVariable ("firstName") String firstName, Model model) {
		Student student = studentservice.findStudentById(firstName);
		model.addAttribute("student",student);
		
		return "student_one";
	}

}
