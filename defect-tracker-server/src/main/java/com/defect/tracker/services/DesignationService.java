package com.defect.tracker.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DesignationDto;

@Service
public interface DesignationService {

	void addDesignation(@Valid DesignationDto designationDto);

	boolean existsByDesignation(String designation);

	boolean existsDesignationById(Long id);

	List<DesignationDto> getAllDesignation();

	DesignationDto getDesignationById(Long id);

}
