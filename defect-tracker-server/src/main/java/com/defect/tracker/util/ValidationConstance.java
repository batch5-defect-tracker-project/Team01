package com.defect.tracker.util;

public class ValidationConstance {

	// Project
	public static final String PROJECT_EXISTS = "Project  Already Exists";
	public static final String TYPE_EXISTS = "Type Already Exists";

	public static final String DESIGNATION_EXISTS = "Designation Already Exists";
	public static final String DESIGNATION_DELETE_EXISTS_BY_ID = "Designation Not Exists";
	public static final String DESIGNATION_NOT_EXISTS_BY_ID = "Designation Not Exist";

   //	Defect
	public static final String DEFECT_EXISTS = "Defect Already Exists";
	public static final String DEFECT_DELETE_EXISTS_BY_ID = "Defect Delete Exists By Id";
	public static final String DEFECT_NOT_EXISTS_BY_ID = "Defect Not Exists";
		
	//Module
	public static final String MODULE_EXISTS = "Module  Already Exists";
	public static final String MODULE_DELETE_EXISTS_BY_ID = "Module  is not Exists";
	public static final String MODULE_NOT_EXISTS_BY_ID =" Module Id is not Exists";
	public static final String SUB_MODULE_EXISTS = "SubModule Alredy Exists";
    public static final String SUB_MODULE_NOT_EXISTS_BY_ID ="Sub Module Id is not Exists";
	// Project Allocation
	public static final String PROJECT_ALLOCATION_EXISTS = "Project Allocation Already Exists";
	public static final String PROJECT_ALLOCATION_EXISTS_BY_ID = "Project Allocation Id Already Exists";
	public static final String PROJECT_ALLOCATION_NOT_EXISTS_BY_ID = "Project Allocation Id Not Exists";

	private ValidationConstance() {
	}
}
