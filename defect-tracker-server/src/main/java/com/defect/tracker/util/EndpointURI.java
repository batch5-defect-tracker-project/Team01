package com.defect.tracker.util;

/**
 * Contains all the rest endpoint url constants
 */
public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	
	private static final String ID ="/{id}";

	// Project
	public static final String PROJECT = BASE_API_PATH + "Project";

	public static final String DESIGNATION =BASE_API_PATH +"Designation" ;
	
	public static final String DESIGNATION_BY_ID = BASE_API_PATH + "Designation" +ID;

	private EndpointURI() {

	}
}
