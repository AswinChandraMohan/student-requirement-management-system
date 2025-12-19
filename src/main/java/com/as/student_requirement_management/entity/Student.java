package com.as.student_requirement_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String contactNumber;
	private String email;
	private String degree;
	private String masters;
	private Double tenthPercent;
	private Double twelfthPercent;
	private Double degreePercent;
	private Double mastersPercent;
	private String yop;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Double getTenthPercent() {
		return tenthPercent;
	}

	public void setTenthPercent(Double tenthPercent) {
		this.tenthPercent = tenthPercent;
	}

	public Double getTwelfthPercent() {
		return twelfthPercent;
	}

	public void setTwelfthPercent(Double twelfthPercent) {
		this.twelfthPercent = twelfthPercent;
	}

	public Double getDegreePercent() {
		return degreePercent;
	}

	public void setDegreePercent(Double degreePercent) {
		this.degreePercent = degreePercent;
	}

	public Double getMastersPercent() {
		return mastersPercent;
	}

	public void setMastersPercent(Double mastersPercent) {
		this.mastersPercent = mastersPercent;
	}

	public String getYop() {
		return yop;
	}

	public void setYop(String yop) {
		this.yop = yop;
	}

	public String getMasters() {
		return masters;
	}

	public void setMasters(String masters) {
		this.masters = masters;
	}

}
