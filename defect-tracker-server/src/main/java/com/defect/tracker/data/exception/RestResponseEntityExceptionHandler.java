package com.defect.tracker.data.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.defect.tracker.data.response.ValidationFailure;
import com.defect.tracker.data.response.ValidationFailureResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult results = ex.getBindingResult();
		List<ValidationFailureResponse> validationErrors = results.getFieldErrors().stream()
				.map(item -> new ValidationFailureResponse(item.getField(), item.getDefaultMessage()))
				.collect(Collectors.toList());
		return handleExceptionInternal(ex,new ValidationFailure(validationErrors), headers, status, request);
	}
}
