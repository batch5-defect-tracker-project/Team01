package com.defect.tracker.data.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "verificationToken")
public class VerificationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String token;
	private Timestamp expiryDate;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(nullable = false, name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	public VerificationToken() {
	}

	public VerificationToken(String token, Employee employee) {
		this.token = token;
		this.employee = employee;
	}
}
