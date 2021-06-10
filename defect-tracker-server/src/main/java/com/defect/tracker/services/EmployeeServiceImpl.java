package com.defect.tracker.services;

import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.dto.LogInDto;
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

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public boolean isEmailAlreadyExist(String email) {
		return employeeRepository.existsByEmail(email);
	}

	@Override
	public void registerEmployee(EmployeeDto employeeDto) throws MessagingException {
		employeeDto.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
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
		System.out.println(email);
		Employee employee = employeeRepository.findByEmail(email);
		System.out.println(employee.getId());
		return employee.getId();
	}

	@Override
	public void updateEmployeeById(EmployeeDto employeeDto) throws MessagingException {
		employeeDto.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
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

	@Override
	public void deleteEmployeeById(Long id) {
		if (verificationService.existsTokenByEmployee(id)) {
			verificationService.delete(id);
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<EmployeeDto> findAll() {
		return mapper.map(employeeRepository.findAll(), EmployeeDto.class);
	}

	@Override
	public EmployeeDto findEmployeeById(Long id) {
		return mapper.map(employeeRepository.findById(id).get(), EmployeeDto.class);
	}

	@Override
	public boolean logIn(@Valid LogInDto logInDto) {
		Employee employee = employeeRepository.findByEmail(logInDto.getUserName());
		if (logInDto.getUserName().equalsIgnoreCase(employee.getEmail())
				&& bCryptPasswordEncoder.matches(logInDto.getPassword(), employee.getPassword())) {
			return true;
		}
		return false;
	}


}
