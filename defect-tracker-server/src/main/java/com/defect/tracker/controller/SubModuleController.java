package com.defect.tracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.defect.tracker.data.dto.ModuleDto;
import com.defect.tracker.data.dto.SubModuleDto;
import com.defect.tracker.data.entities.Module;
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
	

	@PostMapping(value = EndpointURI.SUB_MODULE)
	public ResponseEntity<Object> addSubModule(@Valid @RequestBody SubModuleDto subModuleDto) {
		
		if (subModuleService.subModuleExits(subModuleDto.getName()))
		{
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS,
					validationFailureStatusCodes.getSubModuleNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		
		SubModule subModule = mapper.map(subModuleDto, SubModule.class);
		subModuleService.createSubModule(subModule);
		return new ResponseEntity<Object>(Constants.SUB_MODULE_ADDED_SUCCESS, HttpStatus.OK);
	}
	
	@PutMapping(value = EndpointURI.SUB_MODULE)
	public ResponseEntity<Object> updateSubModule(@Valid @RequestBody  SubModuleDto subModuleDto) {
		if (subModuleService.exitsById(subModuleDto.getId())) {
			if(subModuleService.isSubModuleNameAlreadyExist(subModuleDto.getName())){
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS,
					validationFailureStatusCodes.getSubModuleNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
			SubModule subModule = mapper.map(subModuleDto,SubModule.class);
		subModuleService.createSubModule(subModule);
		return new ResponseEntity<Object>(Constants.SUB_MODULE_UPDATE_SUCCESS,HttpStatus.OK);
	}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_EXISTS,validationFailureStatusCodes.getExistsById()),HttpStatus.BAD_REQUEST);
	}
}
