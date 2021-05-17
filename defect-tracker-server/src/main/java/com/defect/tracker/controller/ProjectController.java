package com.defect.tracker.controller;

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
	public ResponseEntity<Object> addProject(@Valid @RequestBody ProjectDto projectDto) {
		if (projectService.exitsByProjectName(projectDto.getName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_EXISTS,
					validationFailureStatusCodes.getProjectNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		projectService.addProject(mapper.map(projectDto, Project.class));
		return new ResponseEntity<Object>(Constants.PROJECT_ADDED_SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping(value = EndpointURI.ID)
	public ResponseEntity<Object> deleteProject(@PathVariable Long id) {
		if (projectService.projectIdExits(id)) {
			projectService.deleteProjectById(id);
			return new ResponseEntity<Object>(Constants.PROJECT_DELETE_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ID_NOTFOUND,
				validationFailureStatusCodes.getProjectIdNotFound()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndpointURI.ID)
	public ResponseEntity<Object> getEmployeeid(@PathVariable Long id) {
		if (projectService.projectIdExits(id)) {
			return new ResponseEntity<Object>(mapper.map(projectService.getProjectById(id), ProjectDto.class),
					HttpStatus.OK);

		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ID_NOTFOUND,
				validationFailureStatusCodes.getProjectIdNotFound()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndpointURI.PROJECT)
	public ResponseEntity<Object> getProject() {
		return new ResponseEntity<Object>(mapper.map(projectService.getProject(), ProjectDto.class), HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.PROJECT)
	public ResponseEntity<Object> updateProject(@Valid @RequestBody ProjectDto projectDto) {
		if (projectService.projectIdExits(projectDto.getId())) {
			if (projectService.exitsByProjectName(projectDto.getName())) {
				if (projectService.getProjectByName(projectDto.getId()).equals(projectDto.getName())) {
					projectService.updateProject(mapper.map(projectDto, Project.class));
					return new ResponseEntity<Object>(Constants.PROJECT_UPDATE_SUCCESS, HttpStatus.OK);
				}
				return new ResponseEntity<>(
						new ValidationFailureResponse(ValidationConstance.PROJECT_UPDATE_EXISTS,
								validationFailureStatusCodes.getGetProjectNameAlreadyUseByAnotherProject()),
						HttpStatus.BAD_REQUEST);
			}
			projectService.updateProject(mapper.map(projectDto, Project.class));
			return new ResponseEntity<Object>(Constants.PROJECT_UPDATE_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ID_NOTFOUND,
				validationFailureStatusCodes.getProjectIdNotFound()), HttpStatus.BAD_REQUEST);
	}
}
