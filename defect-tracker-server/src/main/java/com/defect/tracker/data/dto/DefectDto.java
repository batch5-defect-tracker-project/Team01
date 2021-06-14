package com.defect.tracker.data.dto;


public class DefectDto {

	private Long id;
	private String severity;
	private String priority;
	private String description;
	private String stepsToReCreate;
	private String status;
	private String comments;
	private String File;
	private Long moduleId;    	
	private Long assignedToId;
	private Long assignedById;
	private Long projectId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStepsToReCreate() {
		return stepsToReCreate;
	}
	public void setStepsToReCreate(String stepsToReCreate) {
		this.stepsToReCreate = stepsToReCreate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		File = file;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public Long getAssignedToId() {
		return assignedToId;
	}
	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}
	public Long getAssignedById() {
		return assignedById;
	}
	public void setAssignedById(Long assignedById) {
		this.assignedById = assignedById;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	
	

}

