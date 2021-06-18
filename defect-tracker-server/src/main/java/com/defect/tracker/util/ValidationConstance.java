package com.defect.tracker.util;

public class ValidationConstance {

	// Project
	public static final String PROJECT_EXISTS = "Project  Already Exists";
	public static final String PROJECT_UPDATE_EXISTS = "Project name already use another project";
	public static final String ID_NOTFOUND = "Id  Not Found";
	public static final String PROJECTNAME_NOTFOUND = "projectName not found";
	public static final String DEFECT_STATUS_NULL = "defect status null";
	

	public static final String TYPE_EXISTS = "Type Already Exists";

	public static final String DESIGNATION_EXISTS = "Designation Already Exists";
	public static final String DESIGNATION_DELETE_EXISTS_BY_ID = "Designation Not Exists";
	public static final String DESIGNATION_NOT_EXISTS_BY_ID = "Designation Not Exist";

	// Defect
	public static final String DEFECT_EXISTS = "Defect Id Already Exists";
	public static final String DEFECT_STATUS_NO_CHANGE = "defect status no changes";
	public static final String DEFECT_DELETE_EXISTS_BY_ID = "Defect Delete Exists By Id";
	public static final String DEFECT_NOT_EXISTS_BY_ID = "Defect Not Exists";
	public static final String DEFECT_ID_NOT_FOUND = "Defect Id not found";
	public static final String ASSIGNEDBY_ID_NOT_FOUND = "assignedby Id not found";
	public static final String ASSIGNEDTO_ID_NOT_FOUND = "assignedto Id not found";
	public static final String MODULE_ID_NOT_FOUND = "assignedto Id not found";
	public static final String DEFECT_STATUS_CHANGE_NEW = "Defect Status change New";
	
	

	// Module
	public static final String MODULE_EXISTS = "Module  Already Exists";
	public static final String MODULE_DELETE_EXISTS_BY_ID = "Module  is not Exists";
	public static final String MODULE_NOT_EXISTS_BY_ID = " Module Id is not Exists";
	public static final String SUB_MODULE_EXISTS = "SubModule Alredy Exists";
	public static final String SUB_MODULE_NOT_EXISTS_BY_ID = "Sub Module Id is not Exists";
	// Project Allocation
	public static final String PROJECT_ALLOCATION_EXISTS = "Project Allocation Already Exists";
	public static final String PROJECT_ALLOCATION_EXISTS_BY_ID = "Project Allocation Id Already Exists";
	public static final String PROJECT_ALLOCATION_NOT_EXISTS_BY_ID = "Project Allocation Id Not Exists";

	// employee

	public static final String EMPLOYEE_EMAIL_EXISTS = "Employee Email  Already Exists";
	public static final String EMPLOYEE_Id_EXISTS = "Employee Id  Already Exists";
	public static final String EMPLOYEE_Id_NOT_AVAILABLE = "Employee Id  Not Available";
	public static final String EMPLOYEE_NOT_ACTIVE = "Employee Not Active Please Activate Your Account";
	public static final String EMPLOYEE_PROFILE_SIZE_EXCEPTION = "Profile Image Maximum Size 1mb";
	public static final String EMPLOYEE_PROFILE_CONTANTTYPE_EXCEPTION = "Please Select Only Image File";
	public static final String EMPLOYEE_PROFILE_EMPTY = "Profile Picture Empty So Please Select He Photo";
	public static final String TOKEN_INVALID = "Invalid Token Please Sign Up";
	public static final String TOKEN_EXPIRED = "Token Expired";
	public static final String EMPLOYEE_EMAIL_NOT_AVAILABLE = "Your Username / Email Not Much Please SignUp";
	public static final String EMPLOYEE_USERNAME_PASSWORD_ERROR = "Username Or Password Incorrect";

	public static final String DESIGNATION_NOT_FOUND = "Designation Not Found";

	// SubModule
	public static final String SUB_MODULE_DELETE_EXISTS_BY_ID = "SubModule Not Exists";

	private ValidationConstance() {
	}
}
