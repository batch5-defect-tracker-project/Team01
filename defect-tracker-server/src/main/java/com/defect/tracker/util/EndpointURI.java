package com.defect.tracker.util;

/**
 * Contains all the rest endpoint url constants
 */
public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";
	private static final String ID ="/{id}";

	// Project
	public static final String PROJECT = BASE_API_PATH + "project";
	public static final String DEFECT = BASE_API_PATH + "defect";
	public static final String DEFECT_BY_ID = BASE_API_PATH + "defect"+ID;
	

	private EndpointURI() {

	}
}
