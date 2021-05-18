package com.defect.tracker.util;

public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	private static final String ID = "/{id}";

	// Project
	public static final String PROJECT = BASE_API_PATH + "project";

	// Employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	public static final String EMPLOYEE_ID = BASE_API_PATH + "employee" + ID;
	public static final String EMPLOYEE_ACTIVATION = BASE_API_PATH + "employee/activation";
	public static final String EMPLOYEE_LOGIN = BASE_API_PATH + "employee/login";

	// Designation
	public static final String DESIGNATION = BASE_API_PATH + "designation";
	public static final String DESIGNATION_ID = BASE_API_PATH + "designation" + ID;

	// Module
	public static final String MODULE = BASE_API_PATH + "module";

	private EndpointURI() {
	}
}
