package com.as.student_requirement_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.student_requirement_management.entity.Requirement;


public interface RequirementRepository  extends  JpaRepository<Requirement, Long>{
	
	Optional<Requirement>   findByBranchDealCode(String branchDealCode);
	Optional<List<Requirement>>  findByCompanyName(String companyName);
 
}
