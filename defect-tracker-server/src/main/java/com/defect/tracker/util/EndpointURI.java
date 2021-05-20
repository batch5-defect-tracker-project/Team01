package com.defect.tracker.util;


public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";

	

	public static final String PROJECT = BASE_API_PATH + "project";
	public static final String ID = BASE_API_PATH + "{id}";
	
	
	// Project

	
	//DESIGNATION  

	public static final String DESIGNATION =BASE_API_PATH +"Designation" ;
	
	public static final String DESIGNATION_BY_ID = BASE_API_PATH + "Designation" +ID;


	public static final String MODULE = BASE_API_PATH + "module";
	public static final String MODULE_BY_ID = BASE_API_PATH + "module" + ID;
	public static final String SUB_MODULE =BASE_API_PATH + "sub-module";



	public static final String TYPE = BASE_API_PATH + "Type";

	public static final String DEFECT = BASE_API_PATH + "Defect";
	public static final String DEFECT_BY_ID = BASE_API_PATH + "Defect"+ID;
	


	// Project Allocation
	public static final String PROJECT_ALLOCATION = BASE_API_PATH + "projectAllocation";
	public static final String PROJECT_ALLOCATION_BY_ID = BASE_API_PATH + "projectAllocation" + ID;



	private EndpointURI() {


	}
}