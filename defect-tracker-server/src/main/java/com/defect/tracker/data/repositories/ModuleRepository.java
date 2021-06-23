package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

	boolean existsByName(String name);

	boolean existsByProjectIdAndName(Long projectId, String name);

	boolean existsByIdAndProjectId(Long moduleId, Long projectId);

}
