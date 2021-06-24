package com.defect.tracker.data.dto;

import javax.validation.constraints.NotNull;

public class ProjectAllocationDto {

	private Long id;

	@NotNull(message = "{projectAllocatationDto.projectId.null}")
	private Long projectId;

	@NotNull(message = "{projectAllocationDto.moduleId.null}")
	private Long moduleId;

	@NotNull(message = "{projectAllocationDto.employeeId.null}")
	private Long employeeId;

	private Long subModuleId;

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

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(Long subModuleId) {
		this.subModuleId = subModuleId;
	}

}