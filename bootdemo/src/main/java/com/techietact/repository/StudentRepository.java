package com.techietact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techietact.bo.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByName(String name);
	
	Student findByEmail(String name);
}
