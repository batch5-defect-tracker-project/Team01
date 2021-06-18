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

import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DefectService;
import com.defect.tracker.services.EmailService;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.ModuleService;
import com.defect.tracker.services.ProjectService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DefectController {

	@Autowired
	private DefectService defectService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ModuleService moduleService;

	@Autowired
	EmailService emailService;

	@Autowired
	ProjectService projectService;

	@GetMapping(value = EndpointURI.DEFECT_STATUS_COUNT_BY_PROJECT_NAME)
	public ResponseEntity<Object> getDefect(@PathVariable String projectName) {
		if (!projectService.exitsByProjectName(projectName)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECTNAME_NOTFOUND,
					validationFailureStatusCodes.getProjectNameNotFound()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(defectService.getDefectCount(projectName), HttpStatus.OK);
	}

	@PostMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> addDefect(@Valid @RequestBody DefectDto defectDto) {
		if (!(defectDto.getStatus().equals("new") || defectDto.getStatus().equals("New"))) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_STATUS_CHANGE_NEW,
					validationFailureStatusCodes.getDefectStatusChange()), HttpStatus.BAD_REQUEST);
			
		}
		defectService.createDefect(mapper.map(defectDto, Defect.class));
		emailService.sendDefectStatusAddEmail(defectDto);
		return new ResponseEntity<Object>(Constants.DEFECT_ADDED_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> getAllDefect() {
		List<DefectDto> defectList = mapper.map(defectService.getAllDefect(), DefectDto.class);
		return new ResponseEntity<Object>(defectList, HttpStatus.OK);

	}

	@PutMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> editDefectById(@RequestBody DefectDto defectDto) {
		if (!defectService.existsDefectById(defectDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_ID_NOT_FOUND,
					validationFailureStatusCodes.getDefectIdNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (!defectService.existsAssignedTo(defectDto.getAssignedToId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNEDTO_ID_NOT_FOUND,
					validationFailureStatusCodes.getAssignedToIdNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (!defectService.existsAssignedBy(defectDto.getAssignedById())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNEDBY_ID_NOT_FOUND,
					validationFailureStatusCodes.getAssignedByIdNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (!defectService.existsModuleId(defectDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_ID_NOT_FOUND,
					validationFailureStatusCodes.getModuleIdNotFound()), HttpStatus.BAD_REQUEST);
		}
		if (!defectService.getDefectStatusById(defectDto.getId()).equals(defectDto.getStatus())) {
			defectService.createDefect(mapper.map(defectDto, Defect.class));
			emailService.sendDefectStatusUpdateEmail(defectDto);
			return new ResponseEntity<Object>(Constants.MAIL_SEND_SUCCESS, HttpStatus.OK);
		}
		defectService.createDefect(mapper.map(defectDto, Defect.class));
		return new ResponseEntity<Object>(Constants.DEFECT_UPDATED_SUCCESS, HttpStatus.OK);

	}

	@DeleteMapping(value = EndpointURI.DEFECT_BY_ID)
	public ResponseEntity<Object> deleteDefectById(@PathVariable Long id) {
		if (!defectService.existsDefectById(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_DELETE_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectExistsById()), HttpStatus.BAD_REQUEST);

		}

		defectService.deleteDefectById(id);
		return new ResponseEntity<Object>(Constants.DEFECT_DELETED_SUCCESS, HttpStatus.OK);
	}

//GetById
	@GetMapping(value = EndpointURI.DEFECT_BY_ID)
	public ResponseEntity<Object> findDefectById(@PathVariable Long id) {
		if (defectService.existsDefectById(id)) {
			return new ResponseEntity<Object>(defectService.getDefectById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getDefectById()), HttpStatus.BAD_REQUEST);
	}

}