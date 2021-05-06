package com.defect.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.ProjectDto;
import com.defect.tracker.data.entities.Project;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.ProjectService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndpointURI.PROJECT)
	public ResponseEntity<Object> addProject(@Valid @RequestBody ProjectDto proDto) {
		if (projectService.isProNameAlreadyExist(proDto.getName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_EXISTS,
					validationFailureStatusCodes.getProNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		Project project = mapper.map(proDto, Project.class);
		projectService.createProject(project);
		return new ResponseEntity<Object>(Constants.PROJECT_ADDED_SUCCESS, HttpStatus.OK);
	}
}
