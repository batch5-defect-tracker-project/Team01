package com.defect.tracker.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProjectDto {
	private Long id;
	@NotNull(message = "{project.name.null}")
	@NotEmpty(message = "{project.name.empty}")
	@NotBlank(message = "{project.name.blank}")
	@Pattern(regexp = "^[a-zA-Z.\\-\\/+=@_ ]*$", message = "{project.name.notallow.specialcharacters}")
	private String name;
	
	@NotNull(message = "{abbrevation.name.null}")
	@NotEmpty(message = "{abbrevation.name.empty}")
	@NotBlank(message = "{abbrevation.name.blank}")
	private String abbrevation;

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

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
}
