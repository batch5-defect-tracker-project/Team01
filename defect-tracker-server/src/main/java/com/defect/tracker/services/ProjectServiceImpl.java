package com.defect.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Project;
import com.defect.tracker.data.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public boolean isProNameAlreadyExist(String proName) {
		return projectRepository.existsByName(proName);
	}

	@Override
	public void createProject(Project project) {
		projectRepository.save(project);
	}
}
