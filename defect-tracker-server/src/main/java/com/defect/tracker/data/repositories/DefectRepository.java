package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Defect;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {

	boolean existsByModuleName(String modName);


}
