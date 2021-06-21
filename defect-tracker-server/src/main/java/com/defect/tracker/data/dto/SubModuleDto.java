package com.defect.tracker.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubModuleDto {
	private Long id;
	@NotNull(message = "{SubModuleDto.SubModuleName.null}")
	@NotEmpty(message = "{SubModuleDto.SubModuleName.empty}")
	@NotBlank(message = "{SubModuleDto.SubModuleName.Blank}")
	private String name;
	@NotNull(message = "{SubModuleDto.moduleId.null}")
	private Long moduleId;

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

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
