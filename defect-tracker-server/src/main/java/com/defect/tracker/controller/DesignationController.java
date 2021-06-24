package com.defect.tracker.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.defect.tracker.data.dto.DesignationDto;
import com.defect.tracker.data.entities.Designation;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DesignationService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DesignationController {
	@Autowired
	DesignationService designationService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

// Add
	@PostMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> addDesignation(@Valid @RequestBody DesignationDto designationDto) {
		if (designationService.isDesignationNameAlreadyExist(designationDto.getName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_EXISTS,
					validationFailureStatusCodes.getDesignationNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		Designation designation = mapper.map(designationDto, Designation.class);
		designationService.createDesignation(designation);
		return new ResponseEntity<Object>(Constants.DESIGNATION_ADDED_SUCCESS, HttpStatus.OK);
	}

//	GetAll
	@GetMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> getAllDesigntion() {
		List<DesignationDto> designationList = mapper.map(designationService.getAllDesignation(), DesignationDto.class);
		return new ResponseEntity<Object>(designationList, HttpStatus.OK);
	}

//Delete	
	@DeleteMapping(value = EndpointURI.DESIGNATION_BY_ID)
	public ResponseEntity<Object> deleteDesignation(@PathVariable Long id) {
		if (!designationService.designationExistsById(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDesignationExistsById()), HttpStatus.BAD_REQUEST);
		}
		designationService.designationDeleteById(id);
		return new ResponseEntity<Object>(Constants.DESIGNATION_DELETED_SUCCESS, HttpStatus.OK);
	}

//GetById
	@GetMapping(value = EndpointURI.DESIGNATION_BY_ID)
	public ResponseEntity<Object> findDesignationById(@PathVariable Long id) {
		if (designationService.designationExistsById(id)) {
			return new ResponseEntity<Object>(designationService.getDesignationById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getDesignationExistsById()), HttpStatus.BAD_REQUEST);
	}

//Update
	@PutMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> editDesignationById(@Valid @RequestBody DesignationDto designationDto) {
		if (designationService.designationExistsById(designationDto.getId())) {
			if (designationService.isDesignationNameAlreadyExist(designationDto.getName())) {
				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_EXISTS,
								validationFailureStatusCodes.getDesignationNameAlreadyExists()),
						HttpStatus.BAD_REQUEST);
			}
			Designation designation = mapper.map(designationDto, Designation.class);
			designationService.createDesignation(designation);
			return new ResponseEntity<Object>(Constants.DESIGNATION_UPDATED_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getDesignationExistsById()), HttpStatus.BAD_REQUEST);
	}
}
