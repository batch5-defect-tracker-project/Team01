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
import com.defect.tracker.data.dto.SubModuleDto;
import com.defect.tracker.data.entities.SubModule;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.ModuleService;
import com.defect.tracker.services.SubModuleService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class SubModuleController {
	@Autowired
	SubModuleService subModuleService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;
	@Autowired
	ModuleService moduleService;

	// ------------------------------ Add -API ------------------------------ //
	@PostMapping(value = EndpointURI.SUB_MODULE)
	public ResponseEntity<Object> addSubModule(@Valid @RequestBody SubModuleDto subModuleDto) {

		if (subModuleService.getModuleIdAndName(subModuleDto.getModuleId(), subModuleDto.getName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS,
					validationFailureStatusCodes.getSubModuleNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		SubModule subModule = mapper.map(subModuleDto, SubModule.class);
		subModuleService.createSubModule(subModule);
		return new ResponseEntity<Object>(Constants.SUB_MODULE_ADDED_SUCCESS, HttpStatus.OK);
	}

//	// ------------------------------ UpdateById -API ------------------------------

	@PutMapping(value = EndpointURI.SUB_MODULE)
	public ResponseEntity<Object> updateSubModule(@Valid @RequestBody SubModuleDto subModuleDto) {
		if (subModuleService.exitsSubModuleById(subModuleDto.getId())) {
			if (subModuleService.isSubModuleNameAlreadyExist(subModuleDto.getName())) {

				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS,
						validationFailureStatusCodes.getSubModuleNameAlreadyExists()), HttpStatus.BAD_REQUEST);
			}
			SubModule subModule = mapper.map(subModuleDto, SubModule.class);
			subModuleService.createSubModule(subModule);
			return new ResponseEntity<Object>(Constants.SUB_MODULE_UPDATE_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS,
				validationFailureStatusCodes.getExistsById()), HttpStatus.BAD_REQUEST);
	}

	// ------------------------------ Delete -API ------------------------------

	@DeleteMapping(value = EndpointURI.SUB_MODULE_BY_ID)
	public ResponseEntity<Object> deleteSubModule(@PathVariable Long id) {
		if (!subModuleService.existsById(id)) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.SUB_MODULE_DELETE_EXISTS_BY_ID,
							validationFailureStatusCodes.getExistsById()),
					HttpStatus.BAD_REQUEST);
		}
		subModuleService.deleteById(id);
		return new ResponseEntity<Object>(Constants.SUB_MODULE_DELETED_SUCCESS, HttpStatus.OK);
	}

	// GetById

	@GetMapping(value = EndpointURI.SUB_MODULE_BY_ID)
	public ResponseEntity<Object> findSubModuleById(@PathVariable Long id) {
		if (subModuleService.exitsSubModuleById(id)) {
			System.out.println("Controller");
			SubModule subModule = subModuleService.getSubModuleById(id);
			System.out.println(subModule.getName() + "SubModuleController");
			return new ResponseEntity<Object>(subModule, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getSubModuleById()), HttpStatus.BAD_REQUEST);
	}

//	GETALL
	@GetMapping(value = EndpointURI.SUB_MODULE)
	public ResponseEntity<Object> getAllSubModule() {
		List<SubModuleDto> subModuleList = mapper.map(subModuleService.getAllSubModule(), SubModuleDto.class);
		return new ResponseEntity<Object>(subModuleList, HttpStatus.OK);

	}

}
