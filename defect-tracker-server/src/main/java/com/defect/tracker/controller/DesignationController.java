package com.defect.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.DesignationDto;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DesignationService;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DesignationController {
	@Autowired
	private DesignationService designationService;

	@Autowired
	private ValidationFailureStatusCodes validationFailureStatusCode;

	@PostMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> addDesignation(@Valid @RequestBody DesignationDto designationDto) {
		if (designationService.existsByDesignation(designationDto.getDesignation())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_ALREADY_EXIXTS,
					validationFailureStatusCode.getDesignationAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		designationService.addDesignation(designationDto);
		return new ResponseEntity<Object>(Constants.DESIGNATION_ADDED_SUCCESS, HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> updateDesignation(@Valid @RequestBody DesignationDto designationDto) {
		if (designationService.existsDesignationById(designationDto.getId())) {
			if (designationService.existsByDesignation(designationDto.getDesignation())) {
				String designationShema = designationService.getDesignationById(designationDto.getId())
						.getDesignation();
				if (designationShema.equalsIgnoreCase(designationDto.getDesignation())) {
					designationService.addDesignation(designationDto);
					designationService.addDesignation(designationDto);
					return new ResponseEntity<Object>(Constants.DESIGNATION_UPDATE_SUCCESS, HttpStatus.OK);
				}
				return new ResponseEntity<>(
						new ValidationFailureResponse(ValidationConstance.DESIGNATION_ALREADY_EXIXTS,
								validationFailureStatusCode.getDesignationAlreadyExists()),
						HttpStatus.BAD_REQUEST);
			}
			designationService.addDesignation(designationDto);
			return new ResponseEntity<Object>(Constants.DESIGNATION_UPDATE_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_ID_NOTFOUND,
				validationFailureStatusCode.getDesignationIdNotFound()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndpointURI.DESIGNATION)
	public ResponseEntity<Object> getAllDesignation() {
		return new ResponseEntity<Object>(designationService.getAllDesignation(), HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.DESIGNATION_ID)
	public ResponseEntity<Object> getDesignationById(@PathVariable Long id) {
		if (designationService.existsDesignationById(id)) {
			return new ResponseEntity<Object>(designationService.getDesignationById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DESIGNATION_ID_NOTFOUND,
				validationFailureStatusCode.getDesignationIdNotFound()), HttpStatus.BAD_REQUEST);
	}

}
