
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
	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;

	public String getNameAlreadyExists() {
		return nameAlreadyExists;
	}

	public void setNameAlreadyExists(String nameAlreadyExists) {
		this.nameAlreadyExists = nameAlreadyExists;
	}
	@Value("${validation.type.AlreadyIdExists}")
	private String TypeExistsById;

	public String getTypeExistsById() {
		return TypeExistsById;
	}

	public void setTypeExistsById(String typeExistsById) {
		TypeExistsById = typeExistsById;
	}

}

