package com.defect.tracker.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="defect")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private Long project_id;
	
	@NotNull(message="moduleName is not null")
	@NotBlank(message="moduleName is not blank")
	@NotEmpty(message="moduleName is not empty")
	@Pattern(regexp = "^[a-zA-Z.\\-\\/+=@_ ]*$",message="moduleName not allowed special character and number")
	private String moduleName;
	
	private String severity;
	private String priority;
	private String description;
	private String stepsToReCreateAssignedTo;
	private String comments;
	private String File;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
	public String getStepsToReCreateAssignedTo() {
		return stepsToReCreateAssignedTo;
	}
	public void setStepsToReCreateAssignedTo(String stepsToReCreateAssignedTo) {
		this.stepsToReCreateAssignedTo = stepsToReCreateAssignedTo;
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
	
	
}

