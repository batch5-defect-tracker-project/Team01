package com.defect.tracker.data.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Long contactNumber;
	private boolean isEnabled;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_id", nullable = false)
	private Designation designation;

	public Employee() {

	}

	public Employee(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.password = employee.getPassword();
		this.gender = employee.getGender();
		this.contactNumber = employee.getContactNumber();
		this.isEnabled = employee.isEnabled();
	}

}
