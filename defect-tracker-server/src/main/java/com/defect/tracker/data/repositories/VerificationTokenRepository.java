package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	public VerificationToken findByToken(String token);

	public VerificationToken findByEmployee(Employee employee);

}
