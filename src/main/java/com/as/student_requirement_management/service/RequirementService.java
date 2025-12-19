package com.as.student_requirement_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.student_requirement_management.entity.Requirement;
import com.as.student_requirement_management.repository.RequirementRepository;

@Service
public class RequirementService {

	@Autowired
	private RequirementRepository requirementRepository;

	public Requirement saveRequirement(Requirement requirement) {
		return requirementRepository.save(requirement);
	}

	public List<Requirement> getAllRequirements() {
		return requirementRepository.findAll();
	}

	public Requirement getRequirementById(Long id) {
		return requirementRepository.findById(id).orElse(null);
	}

	public Requirement getRequirementByBranchDealCode(String branchDealCode) {
		return requirementRepository.findByBranchDealCode(branchDealCode).orElse(null);
	}

	public List<Requirement> getRequirementsByCompanyName(String companyName) {
		return requirementRepository.findByCompanyName(companyName).orElse(null);
	}

	public String updateRequirement(Long id, Requirement updatedRequirement) {
		Requirement req = requirementRepository.findById(id).orElse(null);

		if (req != null) {
			req.setBranchDealCode(updatedRequirement.getBranchDealCode());
			req.setCompanyName(updatedRequirement.getCompanyName());
			req.setJobTitle(updatedRequirement.getJobTitle());
			req.setDesignation(updatedRequirement.getDesignation());
			req.setJobLocation(updatedRequirement.getJobLocation());
			req.setSkillsRequired(updatedRequirement.getSkillsRequired());
			req.setNoOfVacantPositions(updatedRequirement.getNoOfVacantPositions());
			req.setNoOfCandidatesRequired(updatedRequirement.getNoOfCandidatesRequired());
			req.setInterviewDate(updatedRequirement.getInterviewDate());
			req.setGenderSpecification(updatedRequirement.getGenderSpecification());
			req.setModeOfInterview(updatedRequirement.getModeOfInterview());
			req.setTenthPercentMin(updatedRequirement.getTenthPercentMin());
			req.setTwelfthPercentMin(updatedRequirement.getTwelfthPercentMin());
			req.setDegreePercentMin(updatedRequirement.getDegreePercentMin());
			req.setQualificationType(updatedRequirement.getQualificationType());

			requirementRepository.save(req);
			return "data updated";
		}
		return "Requirnment not found";
	}

	public String deleteRequirement(Long id) {
		Requirement req = requirementRepository.findById(id).orElse(null);
		if (req != null) {
			requirementRepository.deleteById(id);
			return "Data deleted";
		}
		return "id  not found";
	}
}

