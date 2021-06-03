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
@Table(name = "module")

public class Module {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long id;

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

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
