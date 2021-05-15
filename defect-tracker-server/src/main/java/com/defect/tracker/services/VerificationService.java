package com.defect.tracker.services;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;

@Service
public interface VerificationService {

	public VerificationToken findByToken(String token);

	public VerificationToken findByEmployee(Employee employee);

	public void addVerificationToken(Employee employee, String token);

	public void delete(Long id);

}
