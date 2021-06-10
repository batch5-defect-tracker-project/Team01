package com.defect.tracker.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.defect.tracker.data.entities.Defect;

@Repository
public interface DefectRepository extends CrudRepository<Defect, Long> {

	List<Defect> findByProjectId(Long id);

	boolean existsByAssignedToId(Long id);

	boolean existsByModuleId(Long id);

	boolean existsByAssignedById(Long id);

	Long countByIdAndStatus(Long id, String status);

	




	


}
