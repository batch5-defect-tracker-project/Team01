package com.defect.tracker.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModuleDto {
	private Long id;
	private Long projectId;
	@NotNull(message = "{projectDto.projectName.null}")
	@NotEmpty(message = "{projectDto.projectName.empty}")
	private String name;
	

}
