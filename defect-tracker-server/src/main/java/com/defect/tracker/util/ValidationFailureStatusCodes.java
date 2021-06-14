
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

	// Project
	@Value("${validation.project.AlreadyExists}")
	private String proNameAlreadyExists;

	@Value("${validation.designation.AlreadyExists}")
	private String desigNameAlreadyExists;


//	@Value("${validation.designation.existsById}")

	@Value("${validation.designation.existsById}")
    private String desigExistsById;
	

	@Value("${validation.id.NotFound}")
	private String projectIdNotFound;

	@Value("${validation.Name.UseAnotherProject}")
	private String getProjectNameAlreadyUseByAnotherProject;

	
	// DESIGNATION

	@Value("${validation.designation.AlreadyExists}")
	private String designationNameAlreadyExists;

	@Value("${validation.designation.AlreadyExistsById}")

	private String designationExistsById;

	@Value("${validation.designation.designationById}")
	private String designationById;
	
	@Value("${validation.project.projectIdAlreadyExist}")
	private String projectByIdAlreadyExist;

	@Value("${validation.designation.NotFound}")
	private String designationNotFound;

	@Value("${validation.designation.AlreadyExists}")
	private String designationAlreadyExists;

	@Value("${validation.designation.id.NotFound}")
	private String designationIdNotFound;

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
	
	//SubModule
	@Value("${validation.subModule.subModuleIdAlreadyExist}")
	private String subModuleByIdAlreadyExist;

	@Value("${validation.subModule.subModuleById}")
	private String subModuleById;

	// Project Allocation
	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationExistsById;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String employeeIdAlreadyExists;

	@Value("${validation.projectAllocation.AlreadyExistsId}")
	private String projectAllocationById;

	@Value("${validation.defect.existsById}")
	private String existsDefectById;

	// Defect
	@Value("${validation.defect.AlreadyExists}")
	private String modNameAlreadyExists;

	@Value("${validation.defect.defectExistsById}")
	private String defectExistsById;

	@Value("${validation.defect.defectById}")
	private String defectById;

	@Value("${validation.projectName.AlreadyExists}")
	private String projectNameAlreadyExists;

	@Value("${validation.defect.existsById}")
	private String existsById;
	
	@Value("${validation.project.existsById}")
	private String projectExistsById;
	
	@Value("${validation.defect.existsById}")
	private String assignedByExistsById;
	
	@Value("${validation.employee.existsById}")
	private String assignedToExistsById;

	// Type
	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;
	
	@Value("${validation.type.TypeIdAlreadyExists}")
	private String typeIdNotExists;

	
	public String getTypeIdNotExists() {
		return typeIdNotExists;
	}

	public void setTypeIdNotExists(String typeIdNotExists) {
		this.typeIdNotExists = typeIdNotExists;
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



//
//	@Value("${validation.defect.AlreadyExists}")
//	private String modNameAlreadyExists;
//
//	@Value("${validation.type.AlreadyExists}")
//	private String nameAlreadyExists;
//
//	@Value("${validation.defect.existsById}")
//	private String existsById;
//
//	@Value("${validation.defect.defectById}")
//	private String defectById;


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

	public String getProNameAlreadyExists() {
		return proNameAlreadyExists;
	}

	public void setProNameAlreadyExists(String proNameAlreadyExists) {
		this.proNameAlreadyExists = proNameAlreadyExists;
	}

	public String getDesigNameAlreadyExists() {
		return desigNameAlreadyExists;
	}

	public void setDesigNameAlreadyExists(String desigNameAlreadyExists) {
		this.desigNameAlreadyExists = desigNameAlreadyExists;
	}

	public String getDesigExistsById() {
		return desigExistsById;
	}


	public void setDesigExistsById(String desigExistsById) {
		this.desigExistsById = desigExistsById;
	}

	public String getDesignationExistsById() {
		return designationExistsById;
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

	public String getDesignationNameAlreadyExists() {
		return designationNameAlreadyExists;
	}

	public void setDesignationNameAlreadyExists(String designationNameAlreadyExists) {
		this.designationNameAlreadyExists = designationNameAlreadyExists;
	}
//
//	public String getDesignationExistsById() {
//		return designationExistsById;
//	}

	public void setDesignationExistsById(String designationExistsById) {
		this.designationExistsById = designationExistsById;
	}

	public String getDesignationById() {
		return designationById;
	}

	public void setDesignationById(String designationById) {
		this.designationById = designationById;
	}


	public String getProjectByIdAlreadyExist() {
		return projectByIdAlreadyExist;
	}

	public void setProjectByIdAlreadyExist(String projectByIdAlreadyExist) {
		this.projectByIdAlreadyExist = projectByIdAlreadyExist;
	}

//	public String getModuleNameAlreadyExists() {
//		return moduleNameAlreadyExists;
//	}
//
//	public void setModuleNameAlreadyExists(String moduleNameAlreadyExists) {
//		this.moduleNameAlreadyExists = moduleNameAlreadyExists;
//	}

//
//	public String getModuleExistsById() {
//		return moduleExistsById;
//	}
//
//	public void setModuleExistsById(String moduleExistsById) {
//		this.moduleExistsById = moduleExistsById;
//	}
//
//	public String getModuleById() {
//		return ModuleById;
//	}
//

//	public void setModuleById(String moduleById) {
//		ModuleById = moduleById;
//	}
//
//	public String getSubModuleNameAlreadyExists() {
//		return SubModuleNameAlreadyExists;
//	}
//
//	public void setSubModuleNameAlreadyExists(String subModuleNameAlreadyExists) {
//		SubModuleNameAlreadyExists = subModuleNameAlreadyExists;
//	}
//
//	public String getExitsSubModuleById() {
//		return exitsSubModuleById;
//	}
//
//	public void setExitsSubModuleById(String exitsSubModuleById) {
//		this.exitsSubModuleById = exitsSubModuleById;
//}
//		this.exitsSubMod
	public String getDesignationNotFound() {
		return designationNotFound;
	}

	public void setDesignationNotFound(String designationNotFound) {
		this.designationNotFound = designationNotFound;
	}

	public String getDesignationAlreadyExists() {
		return designationAlreadyExists;
	}

	public void setDesignationAlreadyExists(String designationAlreadyExists) {
		this.designationAlreadyExists = designationAlreadyExists;
	}

	public String getDesignationIdNotFound() {
		return designationIdNotFound;
	}

	public void setDesignationIdNotFound(String designationIdNotFound) {
		this.designationIdNotFound = designationIdNotFound;
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

//
//	public void setProjectAllocationExistsById(String projectAllocationExistsById) {
//		this.projectAllocationExistsById = projectAllocationExistsById;
//	}
//
//	public String getEmployeeIdAlreadyExists() {
//		return employeeIdAlreadyExists;
//	}
//
//	public void setEmployeeIdAlreadyExists(String employeeIdAlreadyExists) {
//		this.employeeIdAlreadyExists = employeeIdAlreadyExists;
//	}

//	public void setProjectAllocationExistsById(String projectAllocationExistsById) {
//		this.projectAllocationExistsById = projectAllocationExistsById;
//	}
//
//	public String getEmployeeIdAlreadyExists() {
//		return employeeIdAlreadyExists;
//	}
//
//	public void setEmployeeIdAlreadyExists(String employeeIdAlreadyExists) {
//		this.employeeIdAlreadyExists = employeeIdAlreadyExists;
//	}

	public void setModuleById(String moduleById) {
		ModuleById = moduleById;
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

	public String getExistsDefectById() {
		return existsDefectById;
	}

	public void setExistsDefectById(String existsDefectById) {
		this.existsDefectById = existsDefectById;
	}

	public String getModNameAlreadyExists() {
		return modNameAlreadyExists;
	}

	public void setModNameAlreadyExists(String modNameAlreadyExists) {
		this.modNameAlreadyExists = modNameAlreadyExists;
	}


//	public String getNameAlreadyExists() {
//		return nameAlreadyExists;
//	}
//
//	public void setNameAlreadyExists(String nameAlreadyExists) {
//		this.nameAlreadyExists = nameAlreadyExists;
//	}
//
//	public String getExistsById() {
//		return existsById;
//	}
//
//	public void setExistsById(String existsById) {
//		this.existsById = existsById;
//}


	public String getDefectExistsById() {
		return defectExistsById;
	}

	public void setDefectExistsById(String defectExistsById) {
		this.defectExistsById = defectExistsById;
	}

	public String getDefectById() {
		return defectById;
	}

	public void setDefectById(String defectById) {
		this.defectById = defectById;
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

	public String getProjectExistsById() {
		return projectExistsById;
	}

	public void setProjectExistsById(String projectExistsById) {
		this.projectExistsById = projectExistsById;
	}

	public String getAssignedByExistsById() {
		return assignedByExistsById;
	}

	public void setAssignedByExistsById(String assignedByExistsById) {
		this.assignedByExistsById = assignedByExistsById;
	}

	public String getAssignedToExistsById() {
		return assignedToExistsById;
	}

	public void setAssignedToExistsById(String assignedToExistsById) {
		this.assignedToExistsById = assignedToExistsById;
	}
	

	
}
