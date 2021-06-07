package com.defect.tracker.data.response;

import com.defect.tracker.data.enums.RestApiResponseStatus;

public class ApiResponse {
	public static final ApiResponse OK = new ApiResponse(RestApiResponseStatus.OK);

	private String status;

	private Integer statusCode;

	public ApiResponse(RestApiResponseStatus restApiResponseStatus) {
		this.status = restApiResponseStatus.getStatus();
		this.statusCode = restApiResponseStatus.getCode();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
