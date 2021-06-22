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

import com.defect.tracker.data.dto.TypeDto;
import com.defect.tracker.data.entities.Type;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.TypeService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class TypeController {

	@Autowired
	TypeService typeService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;

	@PostMapping(value = EndpointURI.TYPE)
	public ResponseEntity<Object> addType(@Valid @RequestBody TypeDto typeDto) {
		if (typeService.isNameAlreadyExists(typeDto.getName())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_EXISTS,
					validationFailureStatusCodes.getNameAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		Type type = mapper.map(typeDto, Type.class);
		typeService.createType(type);
		return new ResponseEntity<Object>(Constants.TYPE_ADDED_SUCCESS, HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.TYPE)
	public ResponseEntity<Object> editTypeById(@Valid @RequestBody TypeDto typeDto) {
		if (typeService.typeExistsById(typeDto.getId())) {
			if (typeService.isNameAlreadyExists(typeDto.getName())) {
				return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_EXISTS,
						validationFailureStatusCodes.getNameAlreadyExists()), HttpStatus.BAD_REQUEST);
			}
			Type type = mapper.map(typeDto, Type.class);
			typeService.createType(type);
			return new ResponseEntity<Object>(Constants.TYPE_UPDATED_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
				validationFailureStatusCodes.getTypeIdNotExists()), HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = EndpointURI.TYPE_BY_ID)
	public ResponseEntity<Object> deleteType(@PathVariable Long id) {
		if (typeService.typeExistsById(id)) {
			typeService.typeDeleteById(id);
			return new ResponseEntity<Object>(Constants.TYPE_DELETED_SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
				validationFailureStatusCodes.getTypeIdNotExists()), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = EndpointURI.TYPE)
	public ResponseEntity<Object> getType() {
		return new ResponseEntity<Object>(mapper.map(typeService.getType(), TypeDto.class), HttpStatus.OK);
	}

	@GetMapping(value = EndpointURI.TYPE_BY_ID)
	public ResponseEntity<Object> findTypeById(@PathVariable Long id) {
		if (typeService.typeExistsById(id)) {
			return new ResponseEntity<Object>(typeService.getTypeById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
				validationFailureStatusCodes.getTypeIdNotExists()), HttpStatus.BAD_REQUEST);
	}

}
