package com.defect.tracker.services;

import java.util.List;

import com.defect.tracker.data.entities.ProjectAllocation;

public interface ProjectAllocationService {

	public void addProjectAllocation(ProjectAllocation projectAllocation);

	public boolean existsById(Long id);

	public void deleteById(Long id);

	public void updateprojectAllocation(ProjectAllocation projectAllocation);

	public Object getProjectAllocationById(Long id);

	public List<ProjectAllocation> getAllProjectAllocation();

	public boolean existsByProjectIdAndEmployeeIdAndModuleIdAndSubModuleId(Long projectId, Long employeeId,
			Long moduleId, Long subModuleId);

}
