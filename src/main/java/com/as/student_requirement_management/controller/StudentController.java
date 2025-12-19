package com.as.student_requirement_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.as.student_requirement_management.entity.Student;
import com.as.student_requirement_management.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student createStudent(@RequestBody Student s) {
		return studentService.createStudent(s);
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/getByname")
	public List<Student> getStudentByName(@RequestParam String name) {
		return studentService.getStudentByName(name);
	}

	@GetMapping("/getByemail")
	public Student getStudentByEmail(@RequestParam String email) {
		return studentService.getStudentByEmail(email);
	}

	@GetMapping
	public List<Student> getAll() {
		return studentService.getAll();
	}

}
