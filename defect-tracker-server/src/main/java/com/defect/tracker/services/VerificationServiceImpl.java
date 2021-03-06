package com.defect.tracker.services;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;
import com.defect.tracker.data.repositories.VerificationTokenRepository;

@Service
public class VerificationServiceImpl implements VerificationService {
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private EmployeeService employeeService;

	@Override
	public VerificationToken findByToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}

	@Override
	public VerificationToken findByEmployee(Employee employee) {
		return verificationTokenRepository.findByEmployee(employee);
	}

	@Override
	public void addVerificationToken(Employee employee, String token) {
		VerificationToken verificationToken = new VerificationToken(token, employee);
		verificationToken.setExpiryDate(calculateExpiryDate(24 * 60));
		verificationTokenRepository.save(verificationToken);
	}

	private Timestamp calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Timestamp(cal.getTime().getTime());
	}

	@Override
	public void delete(Long id) {
		Employee employee = employeeService.findById(id);
		VerificationToken verificationToken = verificationTokenRepository.findByEmployee(employee);
		verificationTokenRepository.deleteById(verificationToken.getId());
	}

	@Override
	public boolean existsTokenByEmployee(Long id) {
		Employee employee = employeeService.findById(id);
		return verificationTokenRepository.existsByEmployee(employee);
	}

}
