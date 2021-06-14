package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Defect;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {

	Long countByPriorityAndProjectName(String string, String projectName);

	Long countBySeverityAndProjectName(String string, String projectName);

	Long countByPriorityAndSeverityAndProjectName(String string, String string2, String projectName);

	Long countByProjectName(String projectName);

}
