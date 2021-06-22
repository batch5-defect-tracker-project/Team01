package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

	boolean existsByName(String name);

	

}
