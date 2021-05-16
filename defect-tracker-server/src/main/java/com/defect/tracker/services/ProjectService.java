package com.defect.tracker.services;

import java.util.List;

import com.defect.tracker.data.entities.Project;

public interface ProjectService {

	public void addProject(Project project);

	public boolean exitsByProjectName(String name);

	public void deleteProjectById(Long id);

	public boolean projectIdExits(Long id);

	public Object getProjectById(Long id);

	public List<Project> getProject();

	public void updateProject(Project project);

	public Object getProjectByName(Long id);

}
