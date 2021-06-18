package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Project;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	Mapper mapper;
	@Override
	public void addProject(Project project) {
		projectRepository.save(project);

	}

	@Override
	public void deleteProjectById(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public boolean projectIdExits(Long id) {
		return projectRepository.existsById(id);
	}

	@Override
	public boolean exitsByProjectName(String projectName) {
		return projectRepository.existsByName(projectName);
	}

	@Override
	public Object getProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public List<Project> getProject() {
		return projectRepository.findAll();
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.save(project);

	}

	@Override
	public Object getProjectByName(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public Project findProjectByName(String projectName) {
		return projectRepository.findByName(projectName);
	}


}
