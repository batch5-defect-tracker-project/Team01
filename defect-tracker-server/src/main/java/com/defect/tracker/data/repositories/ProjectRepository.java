package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.defect.tracker.data.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByName(String projectName);

	public boolean existsByName(String projectName);

}
