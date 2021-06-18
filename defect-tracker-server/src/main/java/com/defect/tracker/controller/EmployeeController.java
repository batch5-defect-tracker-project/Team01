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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.defect.tracker.data.dto.EmployeeDto;
import com.defect.tracker.data.dto.LogInDto;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;
import com.defect.tracker.services.DesignationService;
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
	private DesignationService designationService;

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

		if (!designationService.designationExistsById(employeeDto.getDesignationId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_NOT_FOUND,
					validationFailureStatusCode.getEmpDesignationNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (employeeService.isValidContactNubmer(employeeDto.getContactNumber())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.CONTACT_NUMBER_NOT_VALID,
					validationFailureStatusCode.getEmpContactNumberNotValid()), HttpStatus.BAD_REQUEST);
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

		if (!employeeService.employeeObjectValidation(employeeDto)) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.EMPLOYEE_SOMEFIELDS_NULL_OR_EMPTY,
							validationFailureStatusCode.getEmpFieldsNullOrEmpty()),
					HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(employeeDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_Id_NOT_AVAILABLE,
					validationFailureStatusCode.getEmpIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}

		if (!employeeService.getEmployeeStatus(employeeDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_NOT_ACTIVE,
					validationFailureStatusCode.getEmpNotActive()), HttpStatus.BAD_REQUEST);
		}

		if (!designationService.designationExistsById(employeeDto.getDesignationId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_NOT_FOUND,
					validationFailureStatusCode.getEmpDesignationNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isValidContactNubmer(employeeDto.getContactNumber())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.CONTACT_NUMBER_NOT_VALID,
					validationFailureStatusCode.getEmpContactNumberNotValid()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.updateEmailAlreadyExist(employeeDto.getEmail(), employeeDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMAIL_EXISTS,
					validationFailureStatusCode.getEmpEmailAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		employeeService.updateEmployeeById(employeeDto);
		if (!file.isEmpty()) {
			if (!file.getContentType().equals("image/jpeg")) {
				return new ResponseEntity<>(
						new ValidationFailureResponse(ValidationConstance.EMPLOYEE_PROFILE_CONTANTTYPE_EXCEPTION,
								validationFailureStatusCode.getEmpProfileContenetTypeException()),
						HttpStatus.BAD_REQUEST);
			}
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + employeeDto.getId() + ".jpg"),
					StandardCopyOption.REPLACE_EXISTING);
		}
		return new ResponseEntity<Object>(Constants.EMPLOYEE_UPDATE_SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping(value = EndpointURI.EMPLOYEE_ID)
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable Long id) {
		if (employeeService.isIdAlreadyExists(id)) {
			employeeService.deleteEmployeeById(id);
			return new ResponseEntity<Object>(Constants.EMPLOYEE_SUCCESSFULL_DELETE, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_Id_NOT_AVAILABLE,
				validationFailureStatusCode.getEmpIdNotAvailable()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndpointURI.EMPLOYEE)
	public ResponseEntity<Object> getAllEmployee() {
		return new ResponseEntity<Object>(employeeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.EMPLOYEE_ID)
	public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) {
		if (!employeeService.isIdAlreadyExists(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_Id_NOT_AVAILABLE,
					validationFailureStatusCode.getEmpIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		EmployeeDto employeeDto = employeeService.findEmployeeById(id);
		return new ResponseEntity<Object>(employeeDto, HttpStatus.OK);
	}

	@PostMapping(value = EndpointURI.EMPLOYEE_LOGIN)
	public ResponseEntity<Object> logIn(@Valid @RequestBody LogInDto logInDto) {
		if (!employeeService.isEmailAlreadyExist(logInDto.getUserName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_EMAIL_NOT_AVAILABLE,
					validationFailureStatusCode.getEmpEmailNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		if (employeeService.logIn(logInDto)) {
			return new ResponseEntity<Object>(Constants.EMPLOYEE_SUCCESSFULL_LOGIN, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_USERNAME_PASSWORD_ERROR,
				validationFailureStatusCode.getEmpEmailNotAvailable()), HttpStatus.BAD_REQUEST);
	}

}
