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

import com.defect.tracker.data.entities.Module;
import com.defect.tracker.data.dto.ModuleDto;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.ModuleService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class ModuleController {
	@Autowired
	ModuleService moduleService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

	// ------------------------------ Add -API ------------------------------ //
	@PostMapping(value = EndpointURI.MODULE)
	public ResponseEntity<Object> addModule(@Valid @RequestBody ModuleDto moduleDto) {
		if (moduleService.moduleExits(moduleDto.getName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_EXISTS,
					validationFailureStatusCodes.getModuleNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		Module module = mapper.map(moduleDto, Module.class);
		moduleService.createModule(module);
		return new ResponseEntity<Object>(Constants.MODULE_ADDED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Update By Id -API ------------------------- //
	@PutMapping(value = EndpointURI.MODULE)
	public ResponseEntity<Object> updateModule(@Valid @RequestBody ModuleDto moduleDto) {
		if (moduleService.existsById(moduleDto.getId())) {
			if (moduleService.isModuleNameAlreadyExist(moduleDto.getName())) {
				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_EXISTS,
						validationFailureStatusCodes.getModuleNameAlreadyExists()), HttpStatus.BAD_REQUEST);
			}
			Module module = mapper.map(moduleDto, Module.class);
			moduleService.createModule(module);
			return new ResponseEntity<Object>(Constants.UPDATE_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_EXISTS,
				validationFailureStatusCodes.getExistsById()), HttpStatus.BAD_REQUEST);
	}

	// ------------------------- Get All -API ------------------------- //
	@GetMapping(value = EndpointURI.MODULE)
	public ResponseEntity<Object> getAllModule() {
		List<ModuleDto> moduleList = mapper.map(moduleService.getAllModule(), ModuleDto.class);
		return new ResponseEntity<Object>(moduleList, HttpStatus.OK);

	}

	// ------------------------- Delete By Id -API ------------------------- //
	@DeleteMapping(value = EndpointURI.MODULE_BY_ID)
	public ResponseEntity<Object> deleteModule(@PathVariable Long id) {
		if (!moduleService.existsById(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_DELETE_EXISTS_BY_ID,
					validationFailureStatusCodes.getExistsById()), HttpStatus.BAD_REQUEST);
		}

		moduleService.deleteById(id);
		return new ResponseEntity<Object>(Constants.MODULE_DELETED_SUCCESS, HttpStatus.OK);
	}

	// ------------------------- Get By Id -API ------------------------- //
	@GetMapping(value = EndpointURI.MODULE_BY_ID)
	public ResponseEntity<Object> findDefectById(@PathVariable Long id) {
		if (moduleService.existsById(id)) {
			return new ResponseEntity<Object>(moduleService.getModuleById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getModuleById()), HttpStatus.BAD_REQUEST);
	}

}
