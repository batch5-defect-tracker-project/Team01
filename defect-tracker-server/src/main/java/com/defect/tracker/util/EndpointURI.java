package com.defect.tracker.util;

public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	private static final String ID = "/{id}";
	private static final String STATUS = "/{status}";


	// Project
	public static final String PROJECT = BASE_API_PATH + "project";
	public static final String PROJECT_BY_ID = BASE_API_PATH + "project" + ID;
	public static final String DEFECT_COUNT_BY_ID_AND_STATUS = BASE_API_PATH + "Defect_Count" +ID+ STATUS ;

	// Project Allocation
	public static final String PROJECT_ALLOCATION = BASE_API_PATH + "projectAllocation";
	public static final String PROJECT_ALLOCATION_BY_ID = BASE_API_PATH + "projectAllocation" + ID;

	// Designation
	public static final String DESIGNATION = BASE_API_PATH + "Designation";
	public static final String DESIGNATION_BY_ID = BASE_API_PATH + "Designation" + ID;

	// Module
	public static final String MODULE = BASE_API_PATH + "module";
	public static final String MODULE_BY_ID = BASE_API_PATH + "module" + ID;

	// Sub_Module

	public static final String SUB_MODULE = BASE_API_PATH + "sub-module";
	public static final String SUB_MODULE_BY_ID = BASE_API_PATH + "sub-module" + ID;

	// Defect
	public static final String DEFECT = BASE_API_PATH + "Defect";
	public static final String DEFECT_BY_ID = BASE_API_PATH + "Defect" + ID;

	// Employee
	public static final String EMPLOYEE = BASE_API_PATH + "employee";
	public static final String EMPLOYEE_ID = BASE_API_PATH + "employee" + ID;
	public static final String EMPLOYEE_ACTIVATION = BASE_API_PATH + "employee/activation";
	public static final String EMPLOYEE_LOGIN = BASE_API_PATH + "employee/login";

	// Type
	public static final String TYPE = BASE_API_PATH + "Type";
	public static final String TYPE_BY_ID = BASE_API_PATH + "Type" + ID;

	private EndpointURI() {

	}
}