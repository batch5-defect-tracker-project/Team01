package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.defect.tracker.data.entities.ProjectAllocation;

@Repository
public interface ProjectAllocationRepository extends JpaRepository<ProjectAllocation, Long> {

	boolean existsByProjectIdAndEmployeeIdAndModuleIdAndSubModuleId(Long projectId, Long employeeId, Long moduleId,
			Long subModuleId);

}
