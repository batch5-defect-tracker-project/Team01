package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.ProjectAllocation;
import com.defect.tracker.data.repositories.ProjectAllocationRepository;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
	@Autowired
	private ProjectAllocationRepository projectAllocationRepository;

	@Override
	public void addProjectAllocation(ProjectAllocation projectAllocation) {
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
	public void updateprojectAllocation(ProjectAllocation projectAllocation) {
		projectAllocationRepository.save(projectAllocation);

	}

	@Override
	public Object getProjectAllocationById(Long id) {
		return projectAllocationRepository.findById(id).get();
	}

	@Override
	public List<ProjectAllocation> getAllProjectAllocation() {
		return projectAllocationRepository.findAll();
	}

	@Override
	public boolean existsByProjectIdAndEmployeeIdAndModuleId(Long projectId, Long employeeId, Long moduleId) {
		return projectAllocationRepository.existsByProjectIdAndEmployeeIdAndModuleId(projectId, employeeId, moduleId);
	}

}
