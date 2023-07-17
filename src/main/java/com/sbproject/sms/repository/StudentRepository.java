package com.sbproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbproject.sms.enity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findByFirstName(String firstName);

}
