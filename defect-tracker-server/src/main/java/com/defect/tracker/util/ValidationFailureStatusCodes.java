package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {
	// project
	@Value("${validation.project.AlreadyExists}")
	private String proNameAlreadyExists;

	// employee
	@Value("${validation.employee.not.Active}")
	private String empNotActive;

	@Value("${validation.employee.email.AlreadyExists}")
	private String empEmailAlreadyExists;

	@Value("${validation.employee.id.AlreadyExists}")
	private String empIdAlreadyExists;

	@Value("${validation.employee.id.NotAvailable}")
	private String empIdNotAvailable;

	@Value("${validation.employee.profile.SizeException}")
	private String empProfileSizeException;

	@Value("${validation.employee.profile.ContentTypeException}")
	private String empProfileContenetTypeException;

	@Value("${validation.employee.profile.Empty}")
	private String empProfileIsEmpty;

	@Value("${validation.employee.token.Invalid}")
	private String invalidToken;

	@Value("${validation.employee.token.Expired}")
	private String expiredToken;

	// module
	@Value("${validation.module.AlreadyExists}")
	private String moduleNameAlreadyExists;

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	public void setEmpEmailAlreadyExists(String empEmailAlreadyExists) {
		this.empEmailAlreadyExists = empEmailAlreadyExists;
	}

	public String getEmpEmailAlreadyExists() {
		return empEmailAlreadyExists;
	}

	public String getEmpProfileSizeException() {
		return empProfileSizeException;
	}

	public void setEmpProfileSizeException(String empProfileSizeException) {
		this.empProfileSizeException = empProfileSizeException;
	}

	public String getEmpProfileContenetTypeException() {
		return empProfileContenetTypeException;
	}

	public void setEmpProfileContenetTypeException(String empProfileContenetTypeException) {
		this.empProfileContenetTypeException = empProfileContenetTypeException;
	}

	public String getEmpProfileIsEmpty() {
		return empProfileIsEmpty;
	}

	public void setEmpProfileIsEmpty(String empProfileIsEmpty) {
		this.empProfileIsEmpty = empProfileIsEmpty;
	}

	public String getEmpIdAlreadyExists() {
		return empIdAlreadyExists;
	}

	public void setEmpIdAlreadyExists(String empIdAlreadyExists) {
		this.empIdAlreadyExists = empIdAlreadyExists;
	}

	public String getInvalidToken() {
		return invalidToken;
	}

	public void setInvalidToken(String invalidToken) {
		this.invalidToken = invalidToken;
	}

	public String getExpiredToken() {
		return expiredToken;
	}

	public void setExpiredToken(String expiredToken) {
		this.expiredToken = expiredToken;
	}

	public String getModuleNameAlreadyExists() {
		return moduleNameAlreadyExists;
	}

	public String getExistsById() {
		return getExistsById();
	}

	public void setModuleNameAlreadyExists(String moduleNameAlreadyExists) {
		this.moduleNameAlreadyExists = moduleNameAlreadyExists;
	}

	public String getEmpIdNotAvailable() {
		return empIdNotAvailable;
	}

	public void setEmpIdNotAvailable(String empIdNotAvailable) {
		this.empIdNotAvailable = empIdNotAvailable;
	}

	public String getEmpNotActive() {
		return empNotActive;
	}

	public void setEmpNotActive(String empNotActive) {
		this.empNotActive = empNotActive;
	}

}
