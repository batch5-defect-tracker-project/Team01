package com.defect.tracker.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DesignationDto {
	private Long id;
	@NotNull(message = "{designationDto.designation.null}")
	@NotEmpty(message = "{designationDto.designation.empty}")
	@NotBlank(message = "{designationDto.designation.blank}")
	private String designation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
