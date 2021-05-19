package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// Project
	@Value("${validation.project.AlreadyExists}")
	private String ProjectNameAlreadyExists;

	public String getProjectNameAlreadyExists() {
		return ProjectNameAlreadyExists;
	}

	public void setProjectNameAlreadyExists(String projectNameAlreadyExists) {
		ProjectNameAlreadyExists = projectNameAlreadyExists;
	}

	public String getProjectIdNotFound() {
		return projectIdNotFound;
	}

	public void setProjectIdNotFound(String projectIdNotFound) {
		this.projectIdNotFound = projectIdNotFound;
	}

	@Value("${validation.id.NotFound}")
	private String projectIdNotFound;

	@Value("${validation.Name.UseAnotherProject}")
	private String getProjectNameAlreadyUseByAnotherProject;

	public String getGetProjectNameAlreadyUseByAnotherProject() {
		return getProjectNameAlreadyUseByAnotherProject;
	}

	public void setGetProjectNameAlreadyUseByAnotherProject(String getProjectNameAlreadyUseByAnotherProject) {
		this.getProjectNameAlreadyUseByAnotherProject = getProjectNameAlreadyUseByAnotherProject;
	}


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

	
	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;



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
