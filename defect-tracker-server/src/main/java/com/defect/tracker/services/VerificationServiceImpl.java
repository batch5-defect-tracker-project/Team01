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

}
