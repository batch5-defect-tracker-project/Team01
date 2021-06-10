package com.defect.tracker.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.defect.tracker.data.entities.Project;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long>{
	boolean existsByName(String name);

}
