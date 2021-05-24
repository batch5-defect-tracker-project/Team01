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
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	private String assignedTo;
	private String comments;
	private String File;
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "defect_type",
	    joinColumns= {@JoinColumn(name="defect_id")},
	    inverseJoinColumns = {@JoinColumn(name = "type_id")})
	private List<Type> type;
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "defect_project",
	    joinColumns= {@JoinColumn(name="defect_id")},
	    inverseJoinColumns = {@JoinColumn(name = "project_id")})
	private List<Project> project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "module_id", nullable = false)
	private Module module;
	
	
	
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
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
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

