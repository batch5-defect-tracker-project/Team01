package com.defect.tracker.services;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public interface EmployeeService {

	boolean isEmailAlreadyExist(String email);

	boolean isIdAlreadyExists(Long id);

	void registerEmployee(EmployeeDto employeedto) throws MessagingException;

	void activateEmployee(EmployeeDto employeeDto);

	EmployeeDto getJson(String employee) throws JsonMappingException, JsonProcessingException;

	Long getEmployeeIdByEmail(String email);

	void updateEmployeeById(EmployeeDto employeeDto) throws MessagingException;

	boolean getEmployeeStatus(Long id);

	void deleteEmployeeById(Long id);

	Employee findById(Long id);

}
