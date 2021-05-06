package com.defect.tracker.services;

import com.defect.tracker.data.entities.Project;

public interface ProjectService {

	public boolean isProNameAlreadyExist(String proName);

	public void createProject(Project project);
}
