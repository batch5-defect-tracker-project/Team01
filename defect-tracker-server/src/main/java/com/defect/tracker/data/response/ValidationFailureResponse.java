package com.defect.tracker.data.response;

public class ValidationFailureResponse {
	private String message;
	private String statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public ValidationFailureResponse(String message, String statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}
}
