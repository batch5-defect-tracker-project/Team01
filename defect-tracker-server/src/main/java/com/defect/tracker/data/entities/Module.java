package com.defect.tracker.data.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
@Table(name = "module")

public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
//	private Long projectId;
	private String name;

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getProjectId() {
//		return projectId;
//	}
//
//	public void setProjectId(Long projectId) {
//		this.projectId = projectId;
//	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
