
package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {

	// Project
	@Value("${validation.project.AlreadyExists}")

	private String ProjectNameAlreadyExists;

	public String getProjectNameAlreadyExists() {
		return ProjectNameAlreadyExists;
	}

	public void setProjectNameAlreadyExists(String projectNameAlreadyExists) {
		ProjectNameAlreadyExists = projectNameAlreadyExists;
	}

	public String getProjectIdNotFound() {
		return projectIdNotFound;
	}

	public void setProjectIdNotFound(String projectIdNotFound) {
		this.projectIdNotFound = projectIdNotFound;
	}

	@Value("${validation.id.NotFound}")
	private String projectIdNotFound;

	@Value("${validation.Name.UseAnotherProject}")
	private String getProjectNameAlreadyUseByAnotherProject;

	public String getGetProjectNameAlreadyUseByAnotherProject() {
		return getProjectNameAlreadyUseByAnotherProject;
	}

	public void setGetProjectNameAlreadyUseByAnotherProject(String getProjectNameAlreadyUseByAnotherProject) {
		this.getProjectNameAlreadyUseByAnotherProject = getProjectNameAlreadyUseByAnotherProject;
	}

	private String proNameAlreadyExists;
    //	DESIGNATION
	@Value("${validation.designation.AlreadyExists}")
	private String designationNameAlreadyExists;

	@Value("${validation.designation.AlreadyExistsById}")
	private String designationExistsById;
	
  @Value("${validation.designation.designationById}")
	private String designationById;
	
	@Value("${validation.designation.AlreadyExistById}")
	private String designationById;
  
	// Module
	@Value("${validation.module.AlreadyExists}")
	private String moduleNameAlreadyExists;

	@Value("${validation.module.IdAlreadyExists}")
	private String moduleExistsById;
	@Value("${validation.module.IdAlreadyExists}")
	private String ModuleById;
	@Value("${validation.subModule.AlreadyExists}")
	private String SubModuleNameAlreadyExists;
	@Value("${validation.subModule.AlreadyExists}")
	private String exitsSubModuleById;

	@Value("${validation.subModule.subModuleById}")
	private String subModuleById;

	// Project Allocation
	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationExistsById;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String employeeIdAlreadyExists;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationById;


  //	Defect
	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;

	@Value("${validation.defect.defectExistsById}")
	private String defectExistsById;
	
	@Value("${validation.defect.defectById}")
	private String defectById;
		
	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;

	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;

	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;
	
	@Value("${validation.defect.existsById}")
	private String existsById;
	
	@Value("${validation.defect.defectById}")
	private String defectById;

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;

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

	public String getDesignationById() {
		return designationById;
	}

	public void setDesignationById(String designationById) {
		this.designationById = designationById;
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
    
	public String getModuleById() {
		return ModuleById;
	}

	public void setModuleById(String moduleById) {
		ModuleById = moduleById;
	}


	public String getSubModuleNameAlreadyExists() {
		return SubModuleNameAlreadyExists;

	}

	public void setSubModuleNameAlreadyExists(String subModuleNameAlreadyExists) {
		SubModuleNameAlreadyExists = subModuleNameAlreadyExists;
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
	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;

	}

	public void setExitsSubModuleById(String exitsSubModuleById) {
		this.exitsSubModuleById = exitsSubModuleById;
	}

	public String getProjectAllocationExistsById() {
		return projectAllocationExistsById;
	}

	public void setProjectAllocationExistsById(String projectAllocationExistsById) {
		this.projectAllocationExistsById = projectAllocationExistsById;
	}

	public String getEmployeeIdAlreadyExists() {
		return employeeIdAlreadyExists;
	}

	public void setEmployeeIdAlreadyExists(String employeeIdAlreadyExists) {
		this.employeeIdAlreadyExists = employeeIdAlreadyExists;
	}

	public String getProjectAllocationById() {
		return projectAllocationById;
	}

	public void setProjectAllocationById(String projectAllocationById) {
		this.projectAllocationById = projectAllocationById;
	}

	public String getModNameAlreadyExists() {
		return modNameAlreadyExists;
	}

	public void setModNameAlreadyExists(String modNameAlreadyExists) {
		this.modNameAlreadyExists = modNameAlreadyExists;
	}

	public String getNameAlreadyExists() {
		return nameAlreadyExists;
	}

	public void setNameAlreadyExists(String nameAlreadyExists) {
		this.nameAlreadyExists = nameAlreadyExists;
	}

	public String getDefectExistsById() {
		return defectExistsById;
	}

	public void setDefectExistsById(String defectExistsById) {
		this.defectExistsById = defectExistsById;
    
	public String getExistsById() {
		return existsById;
	}

	public void setExistsById(String existsById) {
		this.existsById = existsById;

	}

	public String getDefectById() {
		return defectById;
	}

	public void setDefectById(String defectById) {
		this.defectById = defectById;
	}

	public String getSubModuleById() {
		return subModuleById;
	}

	public void setSubModuleById(String subModuleById) {
		this.subModuleById = subModuleById;
	}

}


