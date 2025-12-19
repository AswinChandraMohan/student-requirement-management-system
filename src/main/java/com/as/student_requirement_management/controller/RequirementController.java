package com.as.student_requirement_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.student_requirement_management.entity.Requirement;
import com.as.student_requirement_management.entity.Student;
import com.as.student_requirement_management.service.RequirementService;
import com.as.student_requirement_management.service.RequirementStudentService;

@RestController
@RequestMapping("/api/requirements")
public class RequirementController {

	@Autowired
	private RequirementService requirementService;

	@Autowired
	private RequirementStudentService rsService;

	@PostMapping
	public Requirement createRequirement(@RequestBody Requirement requirement) {
		return requirementService.saveRequirement(requirement);
	}

	@GetMapping
	public List<Requirement> getAllRequirements() {
		return requirementService.getAllRequirements();
	}

	@GetMapping("/{id}")
	public Requirement getRequirementById(@PathVariable Long id) {
		return requirementService.getRequirementById(id);
	}

	@GetMapping("/branch/{branchDealCode}")
	public Requirement getByBranchDealCode(@PathVariable String branchDealCode) {
		return requirementService.getRequirementByBranchDealCode(branchDealCode);
	}

	@GetMapping("/company/{companyName}")
	public List<Requirement> getByCompanyName(@PathVariable String companyName) {
		return requirementService.getRequirementsByCompanyName(companyName);
	}

	@PutMapping("/{id}")
	public String updateRequirement(@PathVariable Long id, @RequestBody Requirement requirement) {

		return requirementService.updateRequirement(id, requirement);
	}

	@DeleteMapping("/{id}")
	public String deleteRequirement(@PathVariable Long id) {
		return requirementService.deleteRequirement(id);
	}

	@PostMapping("/{reqId}/student/{stdId}")
	public String mapStudent(@PathVariable Long reqId,@PathVariable Long stdId) {
		return rsService.mapstudent(reqId, stdId);
	}
	
	@GetMapping("reqstd/{reqId}")
	public  List<Student>     getAllStudentByRequirementId(@PathVariable long reqId) {
		return   rsService.getAllStudentByRequirementId(reqId);
	}
	
	@DeleteMapping("/{reqId}/student/{stdId}")
	public String   deleteStdMapping(@PathVariable Long reqId,@PathVariable Long stdId) {
		return  rsService.deleteStdMapping(reqId, stdId);
	}

}