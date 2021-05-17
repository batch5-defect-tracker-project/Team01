package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * contains custom error messages
 *
 */

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	@Value("${validation.project.AlreadyExists}")
	private String proNameAlreadyExists;
	
	@Value("${validation.module.AlreadyExists}")
	private String moduleNameAlreadyExists;
	

	public void setModuleNameAlreadyExists(String moduleNameAlreadyExists) {
		this.moduleNameAlreadyExists = moduleNameAlreadyExists;
	}

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String proAllocExistsById;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String employeeIdAlreadyExists;

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	public String getProAllocExistsById() {
		return proAllocExistsById;
	}

	public void setProAllocExistsById(String proAllocExistsById) {
		this.proAllocExistsById = proAllocExistsById;
	}

	public String getEmployeeIdAlreadyExists() {
		return employeeIdAlreadyExists;
	}

	public void setEmployeeIdAlreadyExists(String employeeIdAlreadyExists) {
		this.employeeIdAlreadyExists = employeeIdAlreadyExists;
	}

	public String getModuleNameAlreadyExists() {
		return moduleNameAlreadyExists;
	}

	public String getExistsById() {
		
		return getExistsById();
	}

	
}
