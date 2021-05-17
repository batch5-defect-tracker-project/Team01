package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

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

}