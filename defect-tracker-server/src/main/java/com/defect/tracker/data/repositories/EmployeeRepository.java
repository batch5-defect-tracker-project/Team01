package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByEmail(String email);

	Employee findByEmail(String email);

	Employee findByName(String name);

	boolean existsByEmailAndId(String email, Long id);
}
