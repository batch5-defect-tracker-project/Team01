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
import com.defect.tracker.data.dto.ProjectAllocationDto;
import com.defect.tracker.data.entities.ProjectAllocation;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.ModuleService;
import com.defect.tracker.services.ProjectAllocationService;
import com.defect.tracker.services.ProjectService;
import com.defect.tracker.services.SubModuleService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class ProjectAllocationController {
	@Autowired
	ProjectService projectService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ModuleService moduleService;
	@Autowired
	SubModuleService subModuleService;
	@Autowired
	ProjectAllocationService projectAllocationService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

	// ------------------------------ Add -API ------------------------------ //
	@PostMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> addProjectAllocation(@Valid @RequestBody ProjectAllocationDto projectAllocationDto) {
		if (!projectService.projectIdExits(projectAllocationDto.getProjectId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_NOT_EXISTS,
					validationFailureStatusCodes.getProjectIdNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(projectAllocationDto.getEmployeeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_Id_NOT_AVAILABLE,
					validationFailureStatusCodes.getEmpIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.existsById(projectAllocationDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getModuleIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		if (projectAllocationService.existsByProjectIdAndEmployeeIdAndModuleIdAndSubModuleId(
				projectAllocationDto.getProjectId(), projectAllocationDto.getEmployeeId(),
				projectAllocationDto.getModuleId(), projectAllocationDto.getSubModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_EXISTS,
					validationFailureStatusCodes.getProjectAllocationExistsById()), HttpStatus.BAD_REQUEST);
		}
		if(!subModuleService.existsByIdAndModuleId(projectAllocationDto.getSubModuleId(),projectAllocationDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS_BY_MODULE_ID, 
					validationFailureStatusCodes.getModuleIdExistsBySubModuleId()),HttpStatus.BAD_REQUEST);
		}
		ProjectAllocation projectAllocation = mapper.map(projectAllocationDto, ProjectAllocation.class);
		projectAllocationService.addProjectAllocation(projectAllocation);
		return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATION_ADDED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Delete By Id -API ------------------------- //
	@DeleteMapping(value = EndpointURI.PROJECT_ALLOCATION_BY_ID)
	public ResponseEntity<Object> deleteProjectAllocation(@PathVariable Long id) {
		if (!projectAllocationService.existsById(id)) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_NOT_EXISTS_BY_ID,
							validationFailureStatusCodes.getProjectAllocationExistsById()),
					HttpStatus.BAD_REQUEST);
		}
		projectAllocationService.deleteById(id);
		return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATION_DELETED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Update By Id -API ------------------------- //

	@PutMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> updateprojectAllocation(
			@Valid @RequestBody ProjectAllocationDto projectAllocationDto) {

		if (!projectAllocationService.existsById(projectAllocationDto.getId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_NOT_EXISTS_BY_ID,
							validationFailureStatusCodes.getProjectAllocationById()),
					HttpStatus.BAD_REQUEST);
		}
		if (!projectService.projectIdExits(projectAllocationDto.getProjectId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_NOT_EXISTS,
					validationFailureStatusCodes.getProjectIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(projectAllocationDto.getEmployeeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.EMPLOYEE_Id_NOT_AVAILABLE,
					validationFailureStatusCodes.getEmpIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.existsById(projectAllocationDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getModuleIdNotAvailable()), HttpStatus.BAD_REQUEST);
		}
		if (projectAllocationService.existsByProjectIdAndEmployeeIdAndModuleIdAndSubModuleId(
				projectAllocationDto.getProjectId(), projectAllocationDto.getEmployeeId(),
				projectAllocationDto.getModuleId(), projectAllocationDto.getSubModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_EXISTS,
					validationFailureStatusCodes.getProjectAllocationExistsById()), HttpStatus.BAD_REQUEST);
		}
		if(!subModuleService.existsByIdAndModuleId(projectAllocationDto.getSubModuleId(),projectAllocationDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS_BY_MODULE_ID, 
					validationFailureStatusCodes.getModuleIdExistsBySubModuleId()),HttpStatus.BAD_REQUEST);
		}
		ProjectAllocation projectAllocation = mapper.map(projectAllocationDto, ProjectAllocation.class);
		projectAllocationService.updateprojectAllocation(projectAllocation);
		return new ResponseEntity<Object>(Constants.PROJECT_ALLOCATION_UPDATED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Get By Id -API ------------------------- //
	@GetMapping(value = EndpointURI.PROJECT_ALLOCATION_BY_ID)
	public ResponseEntity<Object> findProjectAllocationById(@PathVariable Long id) {
		if (projectAllocationService.existsById(id)) {
			return new ResponseEntity<Object>(
					mapper.map(projectAllocationService.getProjectAllocationById(id), ProjectAllocationDto.class),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new ValidationFailureResponse(ValidationConstance.PROJECT_ALLOCATION_NOT_EXISTS_BY_ID,
						validationFailureStatusCodes.getProjectAllocationExistsById()),
				HttpStatus.BAD_REQUEST);
	}

	// ------------------------- Get All -API ------------------------- //
	@GetMapping(value = EndpointURI.PROJECT_ALLOCATION)
	public ResponseEntity<Object> getAllProjectAllocation() {
		List<ProjectAllocationDto> proAllocationList = mapper.map(projectAllocationService.getAllProjectAllocation(),
				ProjectAllocationDto.class);
		return new ResponseEntity<Object>(proAllocationList, HttpStatus.OK);
	}

}
