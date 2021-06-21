package com.defect.tracker.services;

import java.util.List;
import java.util.Optional;

import com.defect.tracker.data.dto.ProjectDto;
import com.defect.tracker.data.entities.Project;

public interface ProjectService {

	public void addProject(Project project);

	public boolean exitsByProjectName(String projectName);

	public void deleteProjectById(Long id);

	public boolean projectIdExits(Long id);

	public Object getProjectById(Long id);

	public List<Project> getProject();

	public void updateProject(Project project);

	public Object getProjectByName(Long id);
	
	public Project findProjectByName(String projectName);
		

}
