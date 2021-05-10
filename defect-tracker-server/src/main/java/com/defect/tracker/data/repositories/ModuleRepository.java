package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.defect.tracker.data.entities.Project;

public interface ModuleRepository  extends JpaRepository<Project, Long> {

}
