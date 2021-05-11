package com.defect.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.ProjectAllocation;
import com.defect.tracker.data.repositories.ProjectAllocationRepository;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
	@Autowired
	private ProjectAllocationRepository projectAllocationRepository;

	// ------------------ Create Project Allocation-------------------------//
	@Override
	public void createProjectAllocation(ProjectAllocation projectAllocation) {
		projectAllocationRepository.save(projectAllocation);

	}

}
