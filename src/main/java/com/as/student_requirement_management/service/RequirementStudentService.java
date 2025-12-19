package com.as.student_requirement_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.student_requirement_management.entity.Requirement;
import com.as.student_requirement_management.entity.RequirementStudent;
import com.as.student_requirement_management.entity.Student;
import com.as.student_requirement_management.repository.RequirementRepository;
import com.as.student_requirement_management.repository.RequirementStudentRepository;
import com.as.student_requirement_management.repository.StudentRepository;

@Service
public class RequirementStudentService {
	@Autowired
	private RequirementRepository requirementRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private RequirementStudentRepository rsRepository;

	public String mapstudent(Long reqId, Long stdId) {
		Requirement req = requirementRepository.findById(reqId).orElse(null);
		Student s = studentRepository.findById(stdId).orElse(null);
		if (req != null && s != null) {
			RequirementStudent rs = new RequirementStudent();
			rs.setStudent(s);
			rs.setRequirement(req);
			rsRepository.save(rs);
			return "Mapped";
		}
		return "data not found";
	}

	public  List<Student>     getAllStudentByRequirementId(long reqId) {
		
		List<RequirementStudent> listRs	=	rsRepository.findByRequirementId(reqId).orElse(null);
		
		List<Student>  stds  = new ArrayList<>();
		
		for(RequirementStudent rs  : listRs) {
				stds.add(rs.getStudent());
		}
		
		return stds;
		
		
	}
	
	public String   deleteStdMapping(Long reqId,Long stdId) {
		Optional<RequirementStudent> o = rsRepository.findByRequirementIdAndStudentId(reqId, stdId);
		if(o.isPresent()) {
			RequirementStudent rs  = o.get();
			rsRepository.delete(rs);
			return "data deleted";
		}		
		return  "Data not found to delete";
	}

}