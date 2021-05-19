
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


	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

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
	
	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;

	
	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;

	public String getNameAlreadyExists() {
		return nameAlreadyExists;
	}

	public void setNameAlreadyExists(String nameAlreadyExists) {
		this.nameAlreadyExists = nameAlreadyExists;
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


	public String getExistsById() {
		return existsById;
	}


	public void setExistsById(String existsById) {
		this.existsById = existsById;
	}


	public String getDefectById() {
		return defectById;
	}


	public void setDefectById(String defectById) {
		this.defectById = defectById;
	}


	@Value("${validation.defect.existsById}")
	private String existsById;

	
	@Value("${validation.defect.defectById}")
	private String defectById;



}

