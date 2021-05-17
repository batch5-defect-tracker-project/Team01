package com.defect.tracker.util;


public final class EndpointURI {

	private static final String BASE_API_PATH = "/api/v1/";

	public static final String PROJECT = BASE_API_PATH + "project";
	public static final String ID = BASE_API_PATH + "{id}";

	private EndpointURI() {

	}
}