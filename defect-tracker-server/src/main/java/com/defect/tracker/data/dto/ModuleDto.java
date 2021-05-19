package com.defect.tracker.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModuleDto {
	private Long id;
	private Long projectId;
	@NotNull(message = "{moduleDto.moduleName.null}")
	@NotEmpty(message = "{moduleDto.moduleName.empty}")
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
