package com.defect.tracker.services;

import com.defect.tracker.data.entities.ProjectAllocation;

public interface ProjectAllocationService {

	public void createProjectAllocation(ProjectAllocation projectAllocation);

	public boolean existsById(Long id);

	public void deleteById(Long id);

	public boolean isEmployeeIdAlreadyExist(Long employeeId);

	public void updateprojectAllocation(ProjectAllocation projectAllocation);

	public Object getProjectAllocationById(Long id);

	public boolean existsByProjectIdAndEmployeeIdAndModuleIdAndSubModuleId(Long projectId, Long employeeId,
			Long moduleId);

}
