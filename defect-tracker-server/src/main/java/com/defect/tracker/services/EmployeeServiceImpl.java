package com.defect.tracker.services;

import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private VerificationService verificationService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private EmailService emailService;

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public boolean isEmailAlreadyExist(String email) {
		return employeeRepository.existsByEmail(email);
	}

	@Override
	public void registerEmployee(EmployeeDto employeeDto) throws MessagingException {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		employeeDto.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
		System.out.println(employeeDto.getPassword());
		employeeDto.setEnabled(false);
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);

		String token = UUID.randomUUID().toString();
		verificationService.addVerificationToken(employee, token);
		emailService.sendMail(employee);
	}

	@Override
	public boolean isIdAlreadyExists(Long id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public void activateEmployee(EmployeeDto employeeDto) {
		employeeDto.setEnabled(true);
		employeeRepository.save(mapper.map(employeeDto, Employee.class));
	}

	@Override
	public EmployeeDto getJson(String employee) throws JsonMappingException, JsonProcessingException {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto = objectMapper.readValue(employee, EmployeeDto.class);
		return employeeDto;
	}

	@Override
	public Long getEmployeeIdByEmail(String email) {
		Employee employee = employeeRepository.findByEmail(email);
		EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
		return employeeDto.getId();
	}

	@Override
	public void updateEmployeeById(EmployeeDto employeeDto) throws MessagingException {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		employeeDto.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
		System.out.println(employeeDto.getPassword());
		employeeDto.setEnabled(true);
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
		emailService.sendUpdatedMail(employee);
	}

	@Override
	public boolean getEmployeeStatus(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		return employee.isEnabled();
	}

}
