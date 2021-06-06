package com.defect.tracker.services;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public interface EmployeeService {

	boolean isEmailAlreadyExist(String email);

	boolean isIdAlreadyExists(Long id);

	void registerEmployee(@Valid @RequestBody EmployeeDto employeedto) throws MessagingException;

	void activateEmployee(EmployeeDto employeeDto);

	EmployeeDto getJson(String employee) throws JsonMappingException, JsonProcessingException;

	Long getEmployeeIdByEmail(String email);

	void updateEmployeeById(@Valid @RequestBody EmployeeDto employeeDto) throws MessagingException;

	boolean getEmployeeStatus(Long id);

	void deleteEmployeeById(Long id);

	Employee findById(Long id);

	EmployeeDto findEmployeeById(Long id);

	List<EmployeeDto> findAll();

}
