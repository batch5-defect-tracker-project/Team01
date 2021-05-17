package com.defect.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.ProjectAllocation;
import com.defect.tracker.data.repositories.ProjectAllocationRepository;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
	@Autowired
	private ProjectAllocationRepository projectAllocationRepository;

	@Override
	public void createProjectAllocation(ProjectAllocation projectAllocation) {
		projectAllocationRepository.save(projectAllocation);

	}

	@Override
	public boolean existsById(Long id) {
		return projectAllocationRepository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		projectAllocationRepository.deleteById(id);

	}

	@Override
	public boolean isEmployeeIdAlreadyExist(Long employeeId) {
		return projectAllocationRepository.existsById(employeeId);
	}

	@Override
	public void updateprojectAllocation(ProjectAllocation projectAllocation) {
		projectAllocationRepository.save(projectAllocation);

	}
}
