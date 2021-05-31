package com.defect.tracker.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

	boolean existsByName(String name);

}
