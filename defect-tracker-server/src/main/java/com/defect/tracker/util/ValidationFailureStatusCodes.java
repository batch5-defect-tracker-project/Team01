
package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// Employee
	@Value("${validation.employee.not.Active}")
	private String employeeNotActive;

	@Value("${validation.employee.email.AlreadyExists}")
	private String employeeEmailAlreadyExists;

	@Value("${validation.employee.email.IncorrectSyntax}")
	private String employeeEmailSynatxError;

	@Value("${validation.employee.id.AlreadyExists}")
	private String employeeIdAlreadyExists;

	@Value("${validation.employee.id.NotAvailable}")
	private String employeeIdNotAvailable;

	@Value("${validation.employee.profile.SizeException}")
	private String employeeProfileSizeException;

	@Value("${validation.employee.profile.ContentTypeException}")
	private String employeeProfileContenetTypeException;

	@Value("${validation.employee.profile.Empty}")
	private String employeeProfileIsEmpty;

	@Value("${validation.employee.token.Invalid}")
	private String employeeInvalidToken;

	@Value("${validation.employee.token.Expired}")
	private String employeeExpiredToken;

	@Value("${validation.employee.email.NotAvailable}")
	private String employeeEmailNotAvailable;

	@Value("${validation.employee.contactNumber.NotValid}")
	private String employeeContactNumberNotValid;

	@Value("${validation.employee.object.fields.NullOrEmpty}")
	private String employeeFieldsNullOrEmpty;

	@Value("${validation.employee.designation.NotFound}")
	private String employeeDesignationNotFound;
	// EndEmployee

	// Designation
	@Value("${validation.designation.AlreadyExists}")
	private String designationNameAlreadyExists;

	@Value("${validation.designation.AlreadyExistsById}")
	private String designationExistsById;
	// EndDesignation

	// Defect
	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;

	@Value("${validation.defect.defectExistsById}")
	private String defectExistsById;

	@Value("${validation.defect.module.existsModuleById}")
	private String defectModuleById;

	@Value("${validation.defect.submodule.existsSubModuleById}")
	private String defectSubModuleById;

	@Value("${validation.defect.project.existsProjectById}")
	private String defectProjectById;

	@Value("${validation.defect.employee.existsAssignToId}")
	private String assignedToExistsById;

	@Value("${validation.defect.employee.existsAssignById}")
	private String assignedByExistsById;

	@Value("${validation.defect.type.existsTypeById}")
	private String defectTypeById;

	@Value("${validation.defect.statusExist}")
	private String statusExist;
	// End Defect

	// Project
	@Value("${validation.project.AlreadyExists}")
	private String proNameAlreadyExists;

	@Value("${validation.project.projectIdAlreadyExist}")
	private String projectByIdAlreadyExist;

	@Value("${validation.employee.object.fields.NullOrEmpty}")
	private String empFieldsNullOrEmpty;

	@Value("${validation.id.NotFound}")
	private String projectIdNotFound;

	@Value("${validation.Name.UseAnotherProject}")
	private String getProjectNameAlreadyUseByAnotherProject;

	@Value("${validation.project.id.NotAvailable}")
	private String projectIdNotAvailable;

	// Module
	@Value("${validation.module.AlreadyExists}")
	private String moduleNameAlreadyExists;

	@Value("${validation.module.IdAlreadyExists}")
	private String moduleExistsById;

	@Value("${validation.module.IdAlreadyExists}")
	private String ModuleById;

	@Value("${validation.module.existsById}")
	private String existsById;

	@Value("${validation.module.id.NotAvailable}")
	private String ModuleIdNotAvailable;

	// Sub Module
	@Value("${validation.subModule.AlreadyExists}")
	private String SubModuleNameAlreadyExists;

	@Value("${validation.subModule.AlreadyExists}")
	private String exitsSubModuleById;

	@Value("${validation.subModule.subModuleIdAlreadyExist}")
	private String subModuleByIdAlreadyExist;

	@Value("${validation.subModule.subModuleById}")
	private String subModuleById;

	// Project Allocation
	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationExistsById;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationById;

	@Value("${validation.projectAllocation.moduleIdExistsBySubModuleId}")
	private String moduleIdExistsBySubModuleId;

	@Value("${validation.projectName.AlreadyExists}")
	private String projectNameAlreadyExists;


	// Type
	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;

	@Value("${validation.type.TypeIdAlreadyExists}")
	private String typeIdNotExists;

	@Value("${validation.project.existsById}")
	private String projectExistsById;

	public String getEmployeeNotActive() {
		return employeeNotActive;
	}

	public void setEmployeeNotActive(String employeeNotActive) {
		this.employeeNotActive = employeeNotActive;
	}

	public String getEmployeeEmailAlreadyExists() {
		return employeeEmailAlreadyExists;
	}

	public void setEmployeeEmailAlreadyExists(String employeeEmailAlreadyExists) {
		this.employeeEmailAlreadyExists = employeeEmailAlreadyExists;
	}

	public String getEmployeeEmailSynatxError() {
		return employeeEmailSynatxError;
	}

	public void setEmployeeEmailSynatxError(String employeeEmailSynatxError) {
		this.employeeEmailSynatxError = employeeEmailSynatxError;
	}

	public String getEmployeeIdAlreadyExists() {
		return employeeIdAlreadyExists;
	}

	public void setEmployeeIdAlreadyExists(String employeeIdAlreadyExists) {
		this.employeeIdAlreadyExists = employeeIdAlreadyExists;
	}

	public String getEmployeeIdNotAvailable() {
		return employeeIdNotAvailable;
	}

	public void setEmployeeIdNotAvailable(String employeeIdNotAvailable) {
		this.employeeIdNotAvailable = employeeIdNotAvailable;
	}

	public String getEmployeeProfileSizeException() {
		return employeeProfileSizeException;
	}

	public void setEmployeeProfileSizeException(String employeeProfileSizeException) {
		this.employeeProfileSizeException = employeeProfileSizeException;
	}

	public String getEmployeeProfileContenetTypeException() {
		return employeeProfileContenetTypeException;
	}

	public void setEmployeeProfileContenetTypeException(String employeeProfileContenetTypeException) {
		this.employeeProfileContenetTypeException = employeeProfileContenetTypeException;
	}

	public String getEmployeeProfileIsEmpty() {
		return employeeProfileIsEmpty;
	}

	public void setEmployeeProfileIsEmpty(String employeeProfileIsEmpty) {
		this.employeeProfileIsEmpty = employeeProfileIsEmpty;
	}

	public String getEmployeeInvalidToken() {
		return employeeInvalidToken;
	}

	public void setEmployeeInvalidToken(String employeeInvalidToken) {
		this.employeeInvalidToken = employeeInvalidToken;
	}

	public String getEmployeeExpiredToken() {
		return employeeExpiredToken;
	}

	public void setEmployeeExpiredToken(String employeeExpiredToken) {
		this.employeeExpiredToken = employeeExpiredToken;
	}

	public String getEmployeeEmailNotAvailable() {
		return employeeEmailNotAvailable;
	}

	public void setEmployeeEmailNotAvailable(String employeeEmailNotAvailable) {
		this.employeeEmailNotAvailable = employeeEmailNotAvailable;
	}

	public String getEmployeeContactNumberNotValid() {
		return employeeContactNumberNotValid;
	}

	public void setEmployeeContactNumberNotValid(String employeeContactNumberNotValid) {
		this.employeeContactNumberNotValid = employeeContactNumberNotValid;
	}

	public String getEmployeeFieldsNullOrEmpty() {
		return employeeFieldsNullOrEmpty;
	}

	public void setEmployeeFieldsNullOrEmpty(String employeeFieldsNullOrEmpty) {
		this.employeeFieldsNullOrEmpty = employeeFieldsNullOrEmpty;
	}

	public String getEmployeeDesignationNotFound() {
		return employeeDesignationNotFound;
	}

	public void setEmployeeDesignationNotFound(String employeeDesignationNotFound) {
		this.employeeDesignationNotFound = employeeDesignationNotFound;
	}

	public String getDesignationNameAlreadyExists() {
		return designationNameAlreadyExists;
	}

	public void setDesignationNameAlreadyExists(String designationNameAlreadyExists) {
		this.designationNameAlreadyExists = designationNameAlreadyExists;
	}

	public String getDesignationExistsById() {
		return designationExistsById;
	}

	public void setDesignationExistsById(String designationExistsById) {
		this.designationExistsById = designationExistsById;
	}

	public String getModNameAlreadyExists() {
		return modNameAlreadyExists;
	}

	public void setModNameAlreadyExists(String modNameAlreadyExists) {
		this.modNameAlreadyExists = modNameAlreadyExists;
	}

	public String getDefectExistsById() {
		return defectExistsById;
	}

	public void setDefectExistsById(String defectExistsById) {
		this.defectExistsById = defectExistsById;
	}

	public String getDefectModuleById() {
		return defectModuleById;
	}

	public void setDefectModuleById(String defectModuleById) {
		this.defectModuleById = defectModuleById;
	}

	public String getDefectSubModuleById() {
		return defectSubModuleById;
	}

	public void setDefectSubModuleById(String defectSubModuleById) {
		this.defectSubModuleById = defectSubModuleById;
	}

	public String getDefectProjectById() {
		return defectProjectById;
	}

	public void setDefectProjectById(String defectProjectById) {
		this.defectProjectById = defectProjectById;
	}

	public String getAssignedToExistsById() {
		return assignedToExistsById;
	}

	public void setAssignedToExistsById(String assignedToExistsById) {
		this.assignedToExistsById = assignedToExistsById;
	}

	public String getAssignedByExistsById() {
		return assignedByExistsById;
	}

	public void setAssignedByExistsById(String assignedByExistsById) {
		this.assignedByExistsById = assignedByExistsById;
	}

	public String getDefectTypeById() {
		return defectTypeById;
	}

	public void setDefectTypeById(String defectTypeById) {
		this.defectTypeById = defectTypeById;
	}

	public String getStatusExist() {
		return statusExist;
	}

	public void setStatusExist(String statusExist) {
		this.statusExist = statusExist;
	}

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

	public String getProjectByIdAlreadyExist() {
		return projectByIdAlreadyExist;
	}

	public void setProjectByIdAlreadyExist(String projectByIdAlreadyExist) {
		this.projectByIdAlreadyExist = projectByIdAlreadyExist;
	}

	public String getEmpFieldsNullOrEmpty() {
		return empFieldsNullOrEmpty;
	}

	public void setEmpFieldsNullOrEmpty(String empFieldsNullOrEmpty) {
		this.empFieldsNullOrEmpty = empFieldsNullOrEmpty;
	}

	public String getProjectIdNotFound() {
		return projectIdNotFound;
	}

	public void setProjectIdNotFound(String projectIdNotFound) {
		this.projectIdNotFound = projectIdNotFound;
	}

	public String getGetProjectNameAlreadyUseByAnotherProject() {
		return getProjectNameAlreadyUseByAnotherProject;
	}

	public void setGetProjectNameAlreadyUseByAnotherProject(String getProjectNameAlreadyUseByAnotherProject) {
		this.getProjectNameAlreadyUseByAnotherProject = getProjectNameAlreadyUseByAnotherProject;
	}

	public String getProjectIdNotAvailable() {
		return projectIdNotAvailable;
	}

	public void setProjectIdNotAvailable(String projectIdNotAvailable) {
		this.projectIdNotAvailable = projectIdNotAvailable;
	}

	public String getModuleNameAlreadyExists() {
		return moduleNameAlreadyExists;
	}

	public void setModuleNameAlreadyExists(String moduleNameAlreadyExists) {
		this.moduleNameAlreadyExists = moduleNameAlreadyExists;
	}

	public String getModuleExistsById() {
		return moduleExistsById;
	}

	public void setModuleExistsById(String moduleExistsById) {
		this.moduleExistsById = moduleExistsById;
	}

	public String getModuleById() {
		return ModuleById;
	}

	public void setModuleById(String moduleById) {
		ModuleById = moduleById;
	}

	public String getModuleIdNotAvailable() {
		return ModuleIdNotAvailable;
	}

	public void setModuleIdNotAvailable(String moduleIdNotAvailable) {
		ModuleIdNotAvailable = moduleIdNotAvailable;
	}

	public String getSubModuleNameAlreadyExists() {
		return SubModuleNameAlreadyExists;
	}

	public void setSubModuleNameAlreadyExists(String subModuleNameAlreadyExists) {
		SubModuleNameAlreadyExists = subModuleNameAlreadyExists;
	}

	public String getExitsSubModuleById() {
		return exitsSubModuleById;
	}

	public void setExitsSubModuleById(String exitsSubModuleById) {
		this.exitsSubModuleById = exitsSubModuleById;
	}

	public String getSubModuleByIdAlreadyExist() {
		return subModuleByIdAlreadyExist;
	}

	public void setSubModuleByIdAlreadyExist(String subModuleByIdAlreadyExist) {
		this.subModuleByIdAlreadyExist = subModuleByIdAlreadyExist;
	}

	public String getSubModuleById() {
		return subModuleById;
	}

	public void setSubModuleById(String subModuleById) {
		this.subModuleById = subModuleById;
	}

	public String getProjectAllocationExistsById() {
		return projectAllocationExistsById;
	}

	public void setProjectAllocationExistsById(String projectAllocationExistsById) {
		this.projectAllocationExistsById = projectAllocationExistsById;
	}

	public String getProjectAllocationById() {
		return projectAllocationById;
	}

	public void setProjectAllocationById(String projectAllocationById) {
		this.projectAllocationById = projectAllocationById;
	}

	public String getModuleIdExistsBySubModuleId() {
		return moduleIdExistsBySubModuleId;
	}

	public void setModuleIdExistsBySubModuleId(String moduleIdExistsBySubModuleId) {
		this.moduleIdExistsBySubModuleId = moduleIdExistsBySubModuleId;
	}

	public String getProjectNameAlreadyExists() {
		return projectNameAlreadyExists;
	}

	public void setProjectNameAlreadyExists(String projectNameAlreadyExists) {
		this.projectNameAlreadyExists = projectNameAlreadyExists;
	}

	public String getExistsById() {
		return existsById;
	}

	public void setExistsById(String existsById) {
		this.existsById = existsById;
	}

	public String getNameAlreadyExists() {
		return nameAlreadyExists;
	}

	public void setNameAlreadyExists(String nameAlreadyExists) {
		this.nameAlreadyExists = nameAlreadyExists;
	}

	public String getTypeIdNotExists() {
		return typeIdNotExists;
	}

	public void setTypeIdNotExists(String typeIdNotExists) {
		this.typeIdNotExists = typeIdNotExists;
	}

	public String getProjectExistsById() {
		return projectExistsById;
	}

	public void setProjectExistsById(String projectExistsById) {
		this.projectExistsById = projectExistsById;
	}

}
