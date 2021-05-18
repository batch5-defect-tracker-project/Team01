package com.defect.tracker.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DesignationDto;
import com.defect.tracker.data.entities.Designation;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {
	@Autowired
	private DesignationRepository designationRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public void addDesignation(@Valid DesignationDto designationDto) {
		Designation designation = mapper.map(designationDto, Designation.class);
		designationRepository.save(designation);
	}

	@Override
	public boolean existsByDesignation(String designation) {
		return designationRepository.existsByDesignation(designation);
	}

	@Override
	public boolean existsDesignationById(Long id) {
		return designationRepository.existsById(id);
	}

	@Override
	public List<DesignationDto> getAllDesignation() {
		return mapper.map(designationRepository.findAll(), DesignationDto.class);
	}

	@Override
	public DesignationDto getDesignationById(Long id) {
		return mapper.map(designationRepository.findById(id).get(), DesignationDto.class);
	}

}
