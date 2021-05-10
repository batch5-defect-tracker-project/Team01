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

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}
	@Value("${validation.defect.AlreadyExists}")
	private String ModNameAlreadyExists;

	public String getModNameAlreadyExists() {
		return ModNameAlreadyExists;
	}

	public void setModNameAlreadyExists(String modNameAlreadyExists) {
		ModNameAlreadyExists = modNameAlreadyExists;
	}
	
	
}
