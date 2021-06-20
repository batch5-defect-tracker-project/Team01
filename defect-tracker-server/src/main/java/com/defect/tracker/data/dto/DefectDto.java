package com.defect.tracker.data.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class DefectDto {

	private Long id;
	
	@NotNull(message = "{defectDto.defectSeverity.null}")
	@NotBlank(message = "{defectDto.defectSeverity.blank}")
	@NotEmpty(message = "{defectDto.defectSeverity.empty}")
	private String severity;
	
	@NotNull(message = "{defectDto.defectPriority.null}")
	@NotBlank(message = "{defectDto.defectPriority.blank}")
	@NotEmpty(message = "{defectDto.defectPriority.empty}")
	private String priority;
	
	@NotNull(message = "{defectDto.defectDescription.null}")
	@NotBlank(message = "{defectDto.defectDescription.blank}")
	@NotEmpty(message = "{defectDto.defectDescription.empty}")
	private String description;
	
	@NotNull(message = "{defectDto.defectStepsToReCreate.null}")
	@NotBlank(message = "{defectDto.defectStepsToReCreate.blank}")
	@NotEmpty(message = "{defectDto.defectStepsToReCreate.empty}")
	private String stepsToReCreate;
	
	@NotNull(message = "{defectDto.defectStatus.null}")
	@NotBlank(message = "{defectDto.defectStatus.blank}")
	@NotEmpty(message = "{defectDto.defectStatus.empty}")
	private String status;
	
	@NotNull(message = "{defectDto.defectComments.null}")
	@NotBlank(message = "{defectDto.defectComments.blank}")
	@NotEmpty(message = "{defectDto.defectComments.empty}")
	private String comments;
	
	@NotNull(message = "{defectDto.defectFile.null}")
	@NotBlank(message = "{defectDto.defectFile.blank}")
	@NotEmpty(message = "{defectDto.defectFile.empty}")
	private String File;
	
	@NotNull(message = "{defectDto.moduleId.null}")
	private Long moduleId;
	
	@NotNull(message = "{defectDto.subModuleId.null}")
	private Long subModuleId;
		
	@NotNull(message = "{defectDto.assignedToId.null}")
	private Long assignedToId;
	
	@NotNull(message = "{defectDto.assignedById.null}")
	private Long assignedById;
	
	@NotNull(message = "{defectDto.projectId.null}")
	private Long projectId;
	
	@NotNull(message = "{defectDto.typeId.null}")
    private Long typeId;

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

	public Long getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(Long subModuleId) {
		this.subModuleId = subModuleId;
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
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}


}

