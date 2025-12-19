package com.as.student_requirement_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.student_requirement_management.entity.Student;
import com.as.student_requirement_management.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student getStudentByEmail(String email) {
		return studentRepository.findByEmail(email).orElse(null);
	}

	public Student getStudentByContact(String contact) {
		return studentRepository.findByContactNumber(contact).orElse(null);
	}

	public String deleteStudent(Long id) {
		Student s = studentRepository.findById(id).orElse(null);
		if (s != null) {
			studentRepository.delete(s);
			return "Data deleted";
		}
		return "Data not found";
	}
	
	public  String updateStudent(long id,Student newStudent) {
		
		Student s = studentRepository.findById(id).orElse(null);
		if (s != null) {
			
			s.setName(newStudent.getName());
			s.setEmail(newStudent.getEmail());
			s.setContactNumber(newStudent.getContactNumber());
			s.setDegree(newStudent.getDegree());
			s.setMasters(newStudent.getMasters());
			s.setTenthPercent(newStudent.getTenthPercent());
			s.setTwelfthPercent(newStudent.getTwelfthPercent());
			s.setDegreePercent(newStudent.getDegreePercent());
			s.setMastersPercent(newStudent.getMastersPercent());
			s.setYop(newStudent.getYop());
			
			studentRepository.save(s);
			
			return  "data updated";
			
		}
		return  "Student data not found";
	}

}

