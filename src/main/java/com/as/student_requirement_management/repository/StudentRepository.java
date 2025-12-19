package com.as.student_requirement_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.student_requirement_management.entity.Student;

public interface StudentRepository  extends  JpaRepository<Student, Long>{
	
	
		List<Student>   findByName(String name);
		Optional<Student>   findByContactNumber(String contactNumber);
		Optional<Student>   findByEmail(String email);
	

}

