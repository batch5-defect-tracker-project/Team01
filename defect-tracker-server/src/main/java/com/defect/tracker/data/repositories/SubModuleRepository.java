package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Module;
import com.defect.tracker.data.entities.SubModule;
@Repository
public interface SubModuleRepository extends JpaRepository<SubModule, Long> {

	boolean existsByName(String name);

	

}
