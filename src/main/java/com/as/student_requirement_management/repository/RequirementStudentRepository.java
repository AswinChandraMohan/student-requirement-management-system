package com.as.student_requirement_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.student_requirement_management.entity.RequirementStudent;

public interface RequirementStudentRepository  extends JpaRepository<RequirementStudent, Long>{


	Optional<List<RequirementStudent>>    findByRequirementId(Long reqid);
	
	
	Optional<RequirementStudent>    findByRequirementIdAndStudentId(Long reqid,Long stdId);
	
	
}

