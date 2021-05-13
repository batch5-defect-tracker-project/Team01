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
	
	@Value("${validation.designation.AlreadyExists}")
	private String desigNameAlreadyExists;

	@Value("${validation.designation.existsById}")
	private String existsById;
	
	@Value("${validation.designation.designationById}")
	private String designationById;
	

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}
    public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
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
	}

	

	
	
	
}
