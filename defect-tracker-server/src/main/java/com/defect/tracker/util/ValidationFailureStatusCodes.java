
package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// Employee
	@Value("${validation.employee.not.Active}")
	private String empNotActive;

	@Value("${validation.employee.email.AlreadyExists}")
	private String empEmailAlreadyExists;

	@Value("${validation.employee.email.IncorrectSyntax}")
	private String empEmailSynatxError;

	@Value("${validation.employee.id.AlreadyExists}")
	private String empIdAlreadyExists;

	@Value("${validation.employee.id.NotAvailable}")
	private String empIdNotAvailable;

	@Value("${validation.employee.profile.SizeException}")
	private String empProfileSizeException;

	@Value("${validation.employee.profile.ContentTypeException}")
	private String empProfileContenetTypeException;

	@Value("${validation.employee.profile.Empty}")
	private String empProfileIsEmpty;

	@Value("${validation.employee.token.Invalid}")
	private String invalidToken;

	@Value("${validation.employee.token.Expired}")
	private String expiredToken;

	@Value("${validation.employee.email.NotAvailable}")
	private String empEmailNotAvailable;

	@Value("${validation.employee.contactNumber.NotValid}")
	private String empContactNumberNotValid;
 //EndEmployee
	
	 // Designation
		@Value("${validation.designation.AlreadyExists}")
		private String designationNameAlreadyExists;

		@Value("${validation.designation.AlreadyExistsById}")
		private String designationExistsById;
//EndDesignation
		
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
//End Defect 
	
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

	@Value("${validation.projectName.AlreadyExists}")
	private String projectNameAlreadyExists;

	@Value("${validation.module.existsById}")
	private String existsById;

	
	// Type
	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;

	@Value("${validation.type.TypeIdAlreadyExists}")
	private String typeIdNotExists;

	@Value("${validation.designation.NotFound}")
	private String designationNotFound;

	@Value("${validation.designation.id.NotFound}")
	private String designationIdNotFound;

	@Value("${validation.designation.existsById}")
	private String designationExistById;

	@Value("${validation.project.existsById}")
	private String projectExistsById;
	
	
	public String getProjectExistsById() {
		return projectExistsById;
	}

	public void setProjectExistsById(String projectExistsById) {
		this.projectExistsById = projectExistsById;
	}

	public String getEmpNotActive() {
		return empNotActive;
	}

	public void setEmpNotActive(String empNotActive) {
		this.empNotActive = empNotActive;
	}

	public String getEmpEmailAlreadyExists() {
		return empEmailAlreadyExists;
	}

	public void setEmpEmailAlreadyExists(String empEmailAlreadyExists) {
		this.empEmailAlreadyExists = empEmailAlreadyExists;
	}

	public String getEmpEmailSynatxError() {
		return empEmailSynatxError;
	}

	public void setEmpEmailSynatxError(String empEmailSynatxError) {
		this.empEmailSynatxError = empEmailSynatxError;
	}

	public String getEmpIdAlreadyExists() {
		return empIdAlreadyExists;
	}

	public void setEmpIdAlreadyExists(String empIdAlreadyExists) {
		this.empIdAlreadyExists = empIdAlreadyExists;
	}

	public String getEmpIdNotAvailable() {
		return empIdNotAvailable;
	}

	public void setEmpIdNotAvailable(String empIdNotAvailable) {
		this.empIdNotAvailable = empIdNotAvailable;
	}

	public String getEmpProfileSizeException() {
		return empProfileSizeException;
	}

	public void setEmpProfileSizeException(String empProfileSizeException) {
		this.empProfileSizeException = empProfileSizeException;
	}

	public String getEmpProfileContenetTypeException() {
		return empProfileContenetTypeException;
	}

	public void setEmpProfileContenetTypeException(String empProfileContenetTypeException) {
		this.empProfileContenetTypeException = empProfileContenetTypeException;
	}

	public String getEmpProfileIsEmpty() {
		return empProfileIsEmpty;
	}

	public void setEmpProfileIsEmpty(String empProfileIsEmpty) {
		this.empProfileIsEmpty = empProfileIsEmpty;
	}

	public String getInvalidToken() {
		return invalidToken;
	}

	public void setInvalidToken(String invalidToken) {
		this.invalidToken = invalidToken;
	}

	public String getExpiredToken() {
		return expiredToken;
	}

	public void setExpiredToken(String expiredToken) {
		this.expiredToken = expiredToken;
	}

	public String getEmpEmailNotAvailable() {
		return empEmailNotAvailable;
	}

	public void setEmpEmailNotAvailable(String empEmailNotAvailable) {
		this.empEmailNotAvailable = empEmailNotAvailable;
	}

	public String getEmpContactNumberNotValid() {
		return empContactNumberNotValid;
	}

	public void setEmpContactNumberNotValid(String empContactNumberNotValid) {
		this.empContactNumberNotValid = empContactNumberNotValid;
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

	public String getDefectProjectById() {
		return defectProjectById;
	}

	public void setDefectProjectById(String defectProjectById) {
		this.defectProjectById = defectProjectById;
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

	public String getDesignationNotFound() {
		return designationNotFound;
	}

	public void setDesignationNotFound(String designationNotFound) {
		this.designationNotFound = designationNotFound;
	}

	public String getDesignationIdNotFound() {
		return designationIdNotFound;
	}

	public void setDesignationIdNotFound(String designationIdNotFound) {
		this.designationIdNotFound = designationIdNotFound;
	}

	public String getDesignationExistById() {
		return designationExistById;
	}

	public void setDesignationExistById(String designationExistById) {
		this.designationExistById = designationExistById;
	}

	public String getDefectSubModuleById() {
		return defectSubModuleById;
	}

	public void setDefectSubModuleById(String defectSubModuleById) {
		this.defectSubModuleById = defectSubModuleById;
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

}
