package com.defect.tracker.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.VerificationService;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ValidationFailureStatusCodes validationFailureStatusCode;

	@Autowired
	private VerificationService verificationService;

	@Autowired
	private Mapper mapper;

	final String UPLOAD_DIR = "E:\\pro_defect___\\defect-tracker-server\\src\\main\\resources\\profiles";

	@PostMapping(value = EndpointURI.EMPLOYEE)
	public ResponseEntity<Object> addEmployee(@Valid @RequestPart("employee") String employee,
			@RequestPart("file") MultipartFile file) throws IllegalStateException, IOException, MessagingException {
		EmployeeDto employeeDto = employeeService.getJson(employee);

		if (employeeService.isEmailAlreadyExist(employeeDto.getEmail())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMAIL_EXISTS,
					validationFailureStatusCode.getEmpEmailAlreadyExists()), HttpStatus.BAD_REQUEST);
		}

		if ((int) file.getSize() > 1048576) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_SIZE_EXCEPTION,
							validationFailureStatusCode.getEmpProfileSizeException()),
					HttpStatus.BAD_REQUEST);
		}

		if (file.isEmpty()) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_EMPTY,
					validationFailureStatusCode.getEmpProfileIsEmpty()), HttpStatus.BAD_REQUEST);
		}

		if (!file.getContentType().equals("image/jpeg")) {
			System.out.println(validationFailureStatusCode.getEmpProfileContenetTypeException());
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_CONTANTTYPE_EXCEPTION,
							validationFailureStatusCode.getEmpProfileContenetTypeException()),
					HttpStatus.BAD_REQUEST);
		}

		employeeService.registerEmployee(employeeDto);
		Long id = employeeService.getEmployeeIdByEmail(employeeDto.getEmail());

		Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + id + ".jpg"),
				StandardCopyOption.REPLACE_EXISTING);
		return new ResponseEntity<Object>(
				Constants.EMPLOYEE_REGISTERED_SUCCESS + "\n" + Constants.EMPLOYEE_PROFILE_ADDED_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.EMPLOYEE_ACTIVATION)
	public ResponseEntity<Object> activation(@RequestParam("token") String token) throws MessagingException {
		VerificationToken verificationToken = verificationService.findByToken(token);
		if (verificationToken == null) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TOKEN_INVALID,
					validationFailureStatusCode.getInvalidToken()), HttpStatus.BAD_REQUEST);
		} else {
			Employee employee = verificationToken.getEmployee();
			if (!employee.isEnabled()) {
				Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
				if (verificationToken.getExpiryDate().before(currentTimestamp)) {
					return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TOKEN_EXPIRED,
							validationFailureStatusCode.getExpiredToken()), HttpStatus.BAD_REQUEST);
				}
				EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
				employeeService.activateEmployee(employeeDto);
				return new ResponseEntity<Object>(Constants.EMPLOYEE_ACTIVATIN_SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(Constants.EMPLOYEE_ALREADY_ACTIVATED, HttpStatus.OK);
		}
	}

	@PutMapping(value = EndpointURI.EMPLOYEE)
	public ResponseEntity<Object> updateEmployeeById(@Valid @RequestPart("employee") String employee,
			@RequestPart("file") MultipartFile file) throws MessagingException, IOException {
		EmployeeDto employeeDto = employeeService.getJson(employee);
		Long id = employeeService.getEmployeeIdByEmail(employeeDto.getEmail());
		if (!employeeService.isIdAlreadyExists(employeeDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_Id_NOT_AVAILABLE,
					validationFailureStatusCode.getEmpIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}

		if (!employeeService.getEmployeeStatus(employeeDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_ACTIVE,
					validationFailureStatusCode.getEmpNotActive()), HttpStatus.BAD_REQUEST);
		}

		if ((int) file.getSize() > 1048576) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_SIZE_EXCEPTION,
							validationFailureStatusCode.getEmpProfileSizeException()),
					HttpStatus.BAD_REQUEST);
		}

		if (file.isEmpty()) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_EMPTY,
					validationFailureStatusCode.getEmpProfileIsEmpty()), HttpStatus.BAD_REQUEST);
		}

		if (!file.getContentType().equals("image/jpeg")) {
			System.out.println(validationFailureStatusCode.getEmpProfileContenetTypeException());
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_CONTANTTYPE_EXCEPTION,
							validationFailureStatusCode.getEmpProfileContenetTypeException()),
					HttpStatus.BAD_REQUEST);
		}

		if (employeeService.isEmailAlreadyExist(employeeDto.getEmail())) {
			if (employeeDto.getId() == id) {
				employeeService.updateEmployeeById(employeeDto);
				Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + id + ".jpg"),
						StandardCopyOption.REPLACE_EXISTING);
				return new ResponseEntity<Object>(Constants.EMPLOYEE_UPDATE_SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMAIL_EXISTS,
					validationFailureStatusCode.getEmpEmailAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		employeeService.updateEmployeeById(employeeDto);
		Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + id + ".jpg"),
				StandardCopyOption.REPLACE_EXISTING);
		return new ResponseEntity<Object>(Constants.EMPLOYEE_UPDATE_SUCCESS, HttpStatus.OK);
	}

}
