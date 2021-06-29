package com.defect.tracker.util;

public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	private static final String ID = "/{id}";
	private static final String PROJECTNAME = "/{projectName}";

	// Project
	public static final String PROJECT = BASE_API_PATH + "project";
	public static final String PROJECT_BY_ID = BASE_API_PATH + "project" + ID;
	public static final String DEFECT_STATUS_COUNT_BY_PROJECT_NAME = BASE_API_PATH + "defect_count" + PROJECTNAME;

	// Project Allocation
	public static final String PROJECT_ALLOCATION = BASE_API_PATH + "projectAllocation";
	public static final String PROJECT_ALLOCATION_BY_ID = BASE_API_PATH + "projectAllocation" + ID;

	// Designation
	public static final String DESIGNATION = BASE_API_PATH + "designation";
	public static final String DESIGNATION_BY_ID = BASE_API_PATH + "designation" + ID;

	// Defect
	public static final String DEFECT = BASE_API_PATH + "defect";
	public static final String DEFECT_BY_ID = BASE_API_PATH + "defect" + ID;

	// Module
	public static final String MODULE = BASE_API_PATH + "module";
	public static final String MODULE_BY_ID = BASE_API_PATH + "module" + ID;

	// Sub_Module
	public static final String SUB_MODULE = BASE_API_PATH + "sub-module";
	public static final String SUB_MODULE_BY_ID = BASE_API_PATH + "sub-module" + ID;

	// Defect
	public static final String DEFECT_ADD = BASE_API_PATH + "defect_add";
	public static final String DEFECT_UPDATE = BASE_API_PATH + "defect_update";

	// Employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	public static final String EMPLOYEE_ID = BASE_API_PATH + "employee" + ID;
	public static final String EMPLOYEE_ACTIVATION = BASE_API_PATH + "employee/activation";
	public static final String EMPLOYEE_LOGIN = BASE_API_PATH + "employee/login";

	// Type
	public static final String TYPE = BASE_API_PATH + "type";
	public static final String TYPE_BY_ID = BASE_API_PATH + "type" + ID;
}