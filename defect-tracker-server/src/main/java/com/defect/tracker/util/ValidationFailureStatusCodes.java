package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// Employee
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

	@Value("${validation.employee.email.NotAvailable}")
	private String empEmailNotAvailable;

	@Value("${validation.designation.NotFound}")
	private String designationNotFound;

	@Value("${validation.designation.AlreadyExists}")
	private String designationAlreadyExists;

	@Value("${validation.designation.id.NotFound}")
	private String designationIdNotFound;

	// Project
	@Value("${validation.project.AlreadyExists}")
	private String proNameAlreadyExists;

	@Value("${validation.designation.AlreadyExists}")
	private String desigNameAlreadyExists;

	@Value("${validation.designation.existsById}")
	private String existsById;

	@Value("${validation.designation.designationById}")
	private String designationById;

	// Module
	@Value("${validation.module.AlreadyExists}")
	private String moduleNameAlreadyExists;

	// Project Allocation
	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationExistsById;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String employeeIdAlreadyExists;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationById;

	@Value("${validation.defect.existsById}")
	private String existsDefectById;

	@Value("${validation.defect.defectById}")
	private String defectById;

	public String getDesigNameAlreadyExists() {
		return desigNameAlreadyExists;
	}

	public void setDesigNameAlreadyExists(String desigNameAlreadyExists) {
		this.desigNameAlreadyExists = desigNameAlreadyExists;
	}

	public String getExistsById() {
		return existsById;
	}

	public void setExistsById(String existsById) {
		this.existsById = existsById;
	}

	public String getDesignationById() {
		return designationById;
	}

	public void setDesignationById(String designationById) {
		this.designationById = designationById;
	}

	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

	public String getModuleNameAlreadyExists() {
		return moduleNameAlreadyExists;
	}

	public void setModuleNameAlreadyExists(String moduleNameAlreadyExists) {
		this.moduleNameAlreadyExists = moduleNameAlreadyExists;
	}

	public String getProjectAllocationExistsById() {
		return projectAllocationExistsById;
	}

	public void setProjectAllocationExistsById(String projectAllocationExistsById) {
		this.projectAllocationExistsById = projectAllocationExistsById;
	}

	public String getEmployeeIdAlreadyExists() {
		return employeeIdAlreadyExists;
	}

	public void setEmployeeIdAlreadyExists(String employeeIdAlreadyExists) {
		this.employeeIdAlreadyExists = employeeIdAlreadyExists;
	}

	public String getProjectAllocationById() {
		return projectAllocationById;
	}

	public void setProjectAllocationById(String projectAllocationById) {
		this.projectAllocationById = projectAllocationById;
	}

	public String getModNameAlreadyExists() {
		return modNameAlreadyExists;
	}

	public void setModNameAlreadyExists(String modNameAlreadyExists) {
		this.modNameAlreadyExists = modNameAlreadyExists;
	}

	public String getDefectById() {
		return defectById;
	}

	public void setDefectById(String defectById) {
		this.defectById = defectById;
	}

	public String getEmpNotActive() {
		return empNotActive;
	}

	public void setEmpNotActive(String empNotActive) {
		this.empNotActive = empNotActive;
	}

	public String getEmpEmailAlreadyExists() {
		return empEmailAlreadyExists;
	}

	public void setEmpEmailAlreadyExists(String empEmailAlreadyExists) {
		this.empEmailAlreadyExists = empEmailAlreadyExists;
	}

	public String getEmpIdAlreadyExists() {
		return empIdAlreadyExists;
	}

	public void setEmpIdAlreadyExists(String empIdAlreadyExists) {
		this.empIdAlreadyExists = empIdAlreadyExists;
	}

	public String getEmpIdNotAvailable() {
		return empIdNotAvailable;
	}

	public void setEmpIdNotAvailable(String empIdNotAvailable) {
		this.empIdNotAvailable = empIdNotAvailable;
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

	public String getEmpEmailNotAvailable() {
		return empEmailNotAvailable;
	}

	public void setEmpEmailNotAvailable(String empEmailNotAvailable) {
		this.empEmailNotAvailable = empEmailNotAvailable;
	}

	public String getDesignationNotFound() {
		return designationNotFound;
	}

	public void setDesignationNotFound(String designationNotFound) {
		this.designationNotFound = designationNotFound;
	}

	public String getDesignationAlreadyExists() {
		return designationAlreadyExists;
	}

	public void setDesignationAlreadyExists(String designationAlreadyExists) {
		this.designationAlreadyExists = designationAlreadyExists;
	}

	public String getDesignationIdNotFound() {
		return designationIdNotFound;
	}

	public void setDesignationIdNotFound(String designationIdNotFound) {
		this.designationIdNotFound = designationIdNotFound;
	}

	public String getExistsDefectById() {
		return existsDefectById;
	}

	public void setExistsDefectById(String existsDefectById) {
		this.existsDefectById = existsDefectById;
	}

}
