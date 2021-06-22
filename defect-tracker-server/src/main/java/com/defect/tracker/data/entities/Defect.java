package com.defect.tracker.data.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "defect")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String severity;
	private String priority;
	private String description;
	private String stepsToReCreate;
	private String status;
	private String comments;
	private String file;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	private Module module;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subModule_id", nullable = false)
	private SubModule subModule;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignedBy", nullable = false)
	private Employee assignedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignedTo", nullable = false)
	private Employee assignedTo;

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}

	public Employee getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Employee assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Employee getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employee assignedTo) {
		this.assignedTo = assignedTo;
	}

}
