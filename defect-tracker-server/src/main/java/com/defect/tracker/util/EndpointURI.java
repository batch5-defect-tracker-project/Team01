package com.defect.tracker.util;

public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";

	// Project
	public static final String PROJECT = BASE_API_PATH + "project";

	// Employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	public static final String EMPLOYEE_ACTIVATION = BASE_API_PATH + "employee/activation";

	// module
	public static final String MODULE = BASE_API_PATH + "module";

	private EndpointURI() {
	}
}
