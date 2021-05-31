package com.defect.tracker.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DesignationDto {
	private Long id;

	@NotNull(message = "name is not null")
	@NotBlank(message = "name is not blank")
	@NotEmpty(message = "name is not empty")
	@Pattern(regexp = "^[a-zA-Z.\\-\\/+=@_ ]*$", message = "name not allowed special character and number")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
