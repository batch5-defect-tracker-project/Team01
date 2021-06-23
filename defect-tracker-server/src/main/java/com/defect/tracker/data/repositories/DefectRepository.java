package com.defect.tracker.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.entities.Project;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {

	Long countByStatusAndProject(String string, Project project);









	




	

	




	


}
