package com.defect.tracker.data.response;

import java.util.Collections;
import java.util.List;

import com.defect.tracker.data.enums.RestApiResponseStatus;

public class ValidationFailure extends ApiResponse {
	private List<ValidationFailureResponse> validationFailures;

	public List<ValidationFailureResponse> getValidationFailures() {
		return validationFailures;
	}

	public void setValidationFailures(List<ValidationFailureResponse> validationFailures) {
		this.validationFailures = validationFailures;
	}

	public ValidationFailure(List<ValidationFailureResponse> validationErrors) {
		super(RestApiResponseStatus.VALIDATION_FAILURE);
		this.validationFailures = validationErrors;
	}

	public ValidationFailure(String field, String code) {
		super(RestApiResponseStatus.VALIDATION_FAILURE);
		ValidationFailureResponse validationFailureResponse = new ValidationFailureResponse(field, code);
		this.validationFailures = Collections.singletonList(validationFailureResponse);
	}
}
