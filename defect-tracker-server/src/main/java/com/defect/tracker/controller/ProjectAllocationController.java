package com.defect.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.ProjectAllocationDto;
import com.defect.tracker.data.entities.ProjectAllocation;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.ProjectAllocationService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class ProjectAllocationController {
	@Autowired
	ProjectAllocationService projectAllocationService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

	// ------------------------------ Add -API ------------------------------ //
	@PostMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> addProjectAllocation(@Valid @RequestBody ProjectAllocationDto projectAllocationDto) {

		ProjectAllocation projectAllocation = mapper.map(projectAllocationDto, ProjectAllocation.class);
		projectAllocationService.createProjectAllocation(projectAllocation);
		return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATION_ADDED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Delete By Id -API ------------------------- //
	@DeleteMapping(value = EndpointURI.PROJECT_ALLOCATION_BY_ID)
	public ResponseEntity<Object> deleteProjectAllocation(@PathVariable Long id) {
		if (!projectAllocationService.existsById(id)) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_NOT_EXISTS_BY_ID,
							validationFailureStatusCodes.getProAllocExistsById()),
					HttpStatus.BAD_REQUEST);
		}
		projectAllocationService.deleteById(id);
		return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATION_DELETED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Update By Id -API ------------------------- //
	@PutMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> updateprojectAllocation(
			@Valid @RequestBody ProjectAllocationDto projectAllocationDto) {
		if (projectAllocationService.existsById(projectAllocationDto.getId())) {
			if (projectAllocationService.isEmployeeIdAlreadyExist(projectAllocationDto.getEmployeeId())) {
				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_EXISTS,
						validationFailureStatusCodes.getEmployeeIdAlreadyExists()), HttpStatus.BAD_REQUEST);
			}
			ProjectAllocation projectAllocation = mapper.map(projectAllocationDto, ProjectAllocation.class);
			projectAllocationService.createProjectAllocation(projectAllocation);
			return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATION_UPDATED_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_NOT_EXISTS_BY_ID,
						validationFailureStatusCodes.getProAllocExistsById()),
				HttpStatus.BAD_REQUEST);
	}

	

}
