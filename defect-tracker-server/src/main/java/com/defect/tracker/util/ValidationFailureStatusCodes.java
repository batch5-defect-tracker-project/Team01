
package com.defect.tracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	@Value("${validation.employee.object.fields.NullOrEmpty}")
	private String empFieldsNullOrEmpty;

	// Project
	@Value("${validation.project.AlreadyExists}")
	private String proNameAlreadyExists;

	@Value("${validation.project.NotAvalable}")
	private String proNameNotAvailable;

	@Value("${validation.designation.AlreadyExists}")
	private String desigNameAlreadyExists;

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

	// Type
	@Value("${validation.type.AlreadyExists}")
	private String nameAlreadyExists;

}
