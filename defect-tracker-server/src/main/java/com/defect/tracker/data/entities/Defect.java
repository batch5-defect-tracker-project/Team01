package com.defect.tracker.data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="defect")
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
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "defect_type",
	    joinColumns= {@JoinColumn(name="defect_id")},
	    inverseJoinColumns = {@JoinColumn(name = "type_id")})
	private List<Type> type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "project_id", nullable = false)
	@JsonIgnoreProperties(value = {"defect", "hibernateLazyInitializer"})
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "module_id", nullable = false)
	@JsonIgnoreProperties(value = {"defect", "hibernateLazyInitializer"})
	private Module module;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "assignedBy", nullable = false)
	@JsonIgnoreProperties(value = {"defect", "hibernateLazyInitializer"})
	private Employee assignedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "assignedTo", nullable = false)
	@JsonIgnoreProperties(value = {"defect", "hibernateLazyInitializer"})
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
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
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
