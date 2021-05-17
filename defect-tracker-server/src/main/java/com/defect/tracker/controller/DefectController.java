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
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DefectController {

	@Autowired
	DefectService defectService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;
	
	@PostMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> addDefect(@Valid @RequestBody DefectDto defectDto) {	
		if (defectService.isModNameAlreadyExist(defectDto.getModuleName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_EXISTS,
					validationFailureStatusCodes.getModNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		Defect defect = mapper.map(defectDto, Defect.class);
		defectService.createDefect(defect);
		return new ResponseEntity<Object>(Constants.DEFECT_ADDED_SUCCESS, HttpStatus.OK);
}
	@GetMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> getAllDefect(){
		List<DefectDto> defectList = mapper.map(defectService.getAllDefect(), DefectDto.class);
		return new ResponseEntity<Object>(defectList, HttpStatus.OK);
		
	}
	@PutMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> editDefectById(@RequestBody DefectDto defectDto){
		if(defectService.existsById(defectDto.getId())) {
			if(defectService.isModNameAlreadyExist(defectDto.getModuleName())) {
				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_EXISTS,
                  validationFailureStatusCodes.getModNameAlreadyExists()),HttpStatus.BAD_REQUEST);
			}
			Defect defect = mapper.map(defectDto, Defect.class);
			defectService.createDefect(defect);
			return new ResponseEntity<Object>(Constants.UPDATED_SUCCESS,HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_EXISTS,
				validationFailureStatusCodes.getExistsById()),HttpStatus.BAD_REQUEST);
		
	}	
	@DeleteMapping(value = EndpointURI.DEFECT_BY_ID)
	  public ResponseEntity<Object>deleteDefectById(@PathVariable Long id){
		if(defectService.existsById(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_DELETE_EXISTS_BY_ID,
					validationFailureStatusCodes.getExistsById()),HttpStatus.BAD_REQUEST);
					
		}
		
		defectService.deleteDefectById(id);
		return new ResponseEntity<Object>(Constants.DELETED_SUCCESS,HttpStatus.OK);
	}
	
	@GetMapping(value = EndpointURI.DEFECT_BY_ID)
	public ResponseEntity<Object>findDefectById(@PathVariable Long id){
		if(defectService.existsById(id)) {
			return new ResponseEntity<Object>(defectService.getDefectById(id),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getDefectById()), HttpStatus.BAD_REQUEST);
	}

}