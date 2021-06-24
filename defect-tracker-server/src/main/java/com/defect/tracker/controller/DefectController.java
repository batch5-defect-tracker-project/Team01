package com.defect.tracker.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.response.ValidationFailureResponse;
import com.defect.tracker.services.DefectService;
import com.defect.tracker.services.EmailService;
import com.defect.tracker.services.EmployeeService;
import com.defect.tracker.services.ModuleService;
import com.defect.tracker.services.ProjectService;
import com.defect.tracker.services.SubModuleService;
import com.defect.tracker.services.TypeService;
import com.defect.tracker.util.Constants;
import com.defect.tracker.util.EndpointURI;
import com.defect.tracker.util.ValidationConstance;
import com.defect.tracker.util.ValidationFailureStatusCodes;

@RestController
public class DefectController {

	@Autowired
	private DefectService defectService;
	@Autowired
	ValidationFailureStatusCodes validationFailureStatusCodes;
	@Autowired
	private Mapper mapper;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ModuleService moduleService;
	@Autowired
	EmailService emailService;
	@Autowired
	SubModuleService subModuleService;
	@Autowired
	ProjectService projectService;
	@Autowired
	TypeService typeService;
	@Autowired
	JavaMailSender javaMailSender;

	@GetMapping(value = EndpointURI.DEFECT_STATUS_COUNT_BY_PROJECT_NAME)
	public ResponseEntity<Object> getDefect(@PathVariable String projectName) {
		if (!projectService.exitsByProjectName(projectName)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECTNAME_NOTFOUND,
					validationFailureStatusCodes.getProjectNameNotFound()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(defectService.getDefectCount(projectName), HttpStatus.OK);
	}

	@PostMapping(value = EndpointURI.DEFECT_ADD)
	public ResponseEntity<Object> createDefect(@Valid @RequestBody DefectDto defectDto) {
		if (!moduleService.existsModuleById(defectDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.exitsSubModuleById(defectDto.getSubModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!projectService.projectIdExits(defectDto.getProjectId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectProjectById()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.exitsModuleIdAndProjectId(defectDto.getModuleId(), defectDto.getProjectId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.MODULE_NOT_RELATION_PROJECT_ID,
							validationFailureStatusCodes.getDefectModuleByIdAndProjectId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.existsByIdAndModuleId(defectDto.getSubModuleId(), defectDto.getModuleId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.SUB_MODULE_NOT_RELATION_MODULE_ID,
							validationFailureStatusCodes.getDefectSubModuleByIdAndModuleId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedById())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_BY_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedByExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedToId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_TO_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedToExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!typeService.typeExistsById(defectDto.getTypeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectTypeById()), HttpStatus.BAD_REQUEST);
		}
		if (!defectDto.getStatus().equalsIgnoreCase("New")) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_STATUS_CHANGE_NEW,
					validationFailureStatusCodes.getDefectStatusChange()), HttpStatus.BAD_REQUEST);
		}
		defectService.createDefect(mapper.map(defectDto, Defect.class));
		emailService.sendDefectStatusAddEmail(defectDto);
		return new ResponseEntity<Object>(Constants.DEFECT_ADDED_SUCCESS, HttpStatus.OK);
	}

	// Add
	@PostMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> addDefect(@Valid @RequestBody DefectDto defectDto) {
		if (!moduleService.existsModuleById(defectDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.exitsSubModuleById(defectDto.getSubModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_ID_NOT_EXIT,
					validationFailureStatusCodes.getDefectSubModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!projectService.projectIdExits(defectDto.getProjectId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectProjectById()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.exitsModuleIdAndProjectId(defectDto.getModuleId(), defectDto.getProjectId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.MODULE_NOT_RELATION_PROJECT_ID,
							validationFailureStatusCodes.getDefectModuleByIdAndProjectId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.existsByIdAndModuleId(defectDto.getSubModuleId(), defectDto.getModuleId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.SUB_MODULE_NOT_RELATION_MODULE_ID,
							validationFailureStatusCodes.getDefectSubModuleByIdAndModuleId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedById())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_BY_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedByExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedToId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_TO_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedToExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!typeService.typeExistsById(defectDto.getTypeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectTypeById()), HttpStatus.BAD_REQUEST);
		}
		if (!defectDto.getStatus().equalsIgnoreCase("New")) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ONLY_ALLOWED_NEW_STATUS,
					validationFailureStatusCodes.getStatusExist()), HttpStatus.BAD_REQUEST);
		}
		if (defectService.existsDefectByModuleIdAndSubModuleIdAndProjectIdAndTypeIdAndCommentsAndDescription(defectDto.getModuleId(),defectDto.getSubModuleId(),defectDto.getProjectId(),defectDto.getTypeId(),defectDto.getComments(),defectDto.getDescription())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_EXISTS,
					validationFailureStatusCodes.getDefectAlreadyExists()), HttpStatus.BAD_REQUEST);
		}
		
		Defect defect = mapper.map(defectDto, Defect.class);
		defectService.createDefect(defect);
		Employee assignedTo = employeeService.findById(defectDto.getAssignedToId());
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("meera10testmail@gmail.com");
		simpleMail.setTo(assignedTo.getEmail());
		simpleMail.setSubject("Defect" + " " + defectDto.getStatus() + " " + "Added");
		simpleMail.setText("ProjectName:" + projectService.getProjectByName(defectDto.getProjectId()) + "\n"
				+ "ModuleName:" + moduleService.findById(defectDto.getModuleId()));

		javaMailSender.send(simpleMail);
		return new ResponseEntity<Object>(Constants.DEFECT_ADDED_SUCCESS, HttpStatus.OK);
	}

	// GetAll
	@GetMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> getAllDefect() {
		List<DefectDto> defectList = mapper.map(defectService.getAllDefect(), DefectDto.class);
		return new ResponseEntity<Object>(defectList, HttpStatus.OK);
	}

	// Update
	@PutMapping(value = EndpointURI.DEFECT)
	public ResponseEntity<Object> editDefectById(@Valid @RequestBody DefectDto defectDto) {

		if (!defectService.existsDefectById(defectDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.existsModuleById(defectDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.exitsSubModuleById(defectDto.getSubModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.SUB_MODULE_ID_NOT_EXIT,
					validationFailureStatusCodes.getDefectSubModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.exitsModuleIdAndProjectId(defectDto.getModuleId(), defectDto.getProjectId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.MODULE_NOT_RELATION_PROJECT_ID,
							validationFailureStatusCodes.getDefectModuleByIdAndProjectId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.existsByIdAndModuleId(defectDto.getSubModuleId(), defectDto.getModuleId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.SUB_MODULE_NOT_RELATION_MODULE_ID,
							validationFailureStatusCodes.getDefectSubModuleByIdAndModuleId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!projectService.projectIdExits(defectDto.getProjectId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectProjectById()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedById())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_BY_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedByExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedToId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_TO_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedToExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!typeService.typeExistsById(defectDto.getTypeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectTypeById()), HttpStatus.BAD_REQUEST);
		}
		String status = (String) defectService.getDefectStatusById(defectDto.getId());
		if (!status.equals(defectDto.getStatus())) {
			defectService.createDefect(mapper.map(defectDto, Defect.class));
			Employee assignedTo = employeeService.findById(defectDto.getAssignedToId());
			if ("Closed".equalsIgnoreCase(defectDto.getStatus()) || "Reopen".equalsIgnoreCase(defectDto.getStatus())) {
				SimpleMailMessage simpleMail = new SimpleMailMessage();
				simpleMail.setFrom("meera10testmail@gmail.com");
				simpleMail.setTo(assignedTo.getEmail());
				simpleMail.setSubject("Defect" + " " + defectDto.getStatus() + "ed");
				simpleMail.setText("ProjectName:" + projectService.getProjectByName(defectDto.getProjectId()) + "\n"
						+ "ModuleName:" + moduleService.findById(defectDto.getModuleId()) + "\n" + "Status:"
						+ defectDto.getStatus());
				javaMailSender.send(simpleMail);
			}
			Employee assignedBy = employeeService.findById(defectDto.getAssignedById());
			if ("Open".equalsIgnoreCase(defectDto.getStatus()) || "Fixed".equalsIgnoreCase(defectDto.getStatus())
					|| "Reject".equalsIgnoreCase(defectDto.getStatus())) {
				SimpleMailMessage simpleMail = new SimpleMailMessage();
				simpleMail.setFrom("meera10testmail@gmail.com");
				simpleMail.setTo(assignedBy.getEmail());
				simpleMail.setSubject("Defect" + " " + defectDto.getStatus() + "ed");
				simpleMail.setText("ProjectName:" + projectService.getProjectByName(defectDto.getProjectId()) + "\n"
						+ "ModuleName:" + moduleService.findById(defectDto.getModuleId()) + "\n" + "Status:"
						+ defectDto.getStatus());
				javaMailSender.send(simpleMail);
			}
			return new ResponseEntity<Object>(Constants.DEFECT_UPDATED_SUCCESS, HttpStatus.OK);
		}
		defectService.createDefect(mapper.map(defectDto, Defect.class));
		return new ResponseEntity<Object>(Constants.DEFECT_UPDATED_SUCCESS, HttpStatus.OK);
	}

	@PutMapping(value = EndpointURI.DEFECT_UPDATE)
	public ResponseEntity<Object> updateDefectById(@Valid @RequestBody DefectDto defectDto) {
		if (!defectService.existsDefectById(defectDto.getId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.existsModuleById(defectDto.getModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.exitsSubModuleById(defectDto.getSubModuleId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.MODULE_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectModuleById()), HttpStatus.BAD_REQUEST);
		}
		if (!moduleService.exitsModuleIdAndProjectId(defectDto.getModuleId(), defectDto.getProjectId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.MODULE_NOT_RELATION_PROJECT_ID,
							validationFailureStatusCodes.getDefectModuleByIdAndProjectId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!subModuleService.existsByIdAndModuleId(defectDto.getSubModuleId(), defectDto.getModuleId())) {
			return new ResponseEntity<>(
					new ValidationFailureResponse(ValidationConstance.SUB_MODULE_NOT_RELATION_MODULE_ID,
							validationFailureStatusCodes.getDefectSubModuleByIdAndModuleId()),
					HttpStatus.BAD_REQUEST);
		}
		if (!projectService.projectIdExits(defectDto.getProjectId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.PROJECT_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectProjectById()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedById())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_BY_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedByExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!employeeService.isIdAlreadyExists(defectDto.getAssignedToId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.ASSIGNED_TO_ID_NOT_EXISTS,
					validationFailureStatusCodes.getAssignedToExistsById()), HttpStatus.BAD_REQUEST);
		}
		if (!typeService.typeExistsById(defectDto.getTypeId())) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.TYPE_ID_NOT_EXISTS,
					validationFailureStatusCodes.getDefectTypeById()), HttpStatus.BAD_REQUEST);
		}
		if (!defectService.getDefectStatusById(defectDto.getId()).equalsIgnoreCase(defectDto.getStatus())) {
			defectService.createDefect(mapper.map(defectDto, Defect.class));
			emailService.sendDefectStatusUpdateEmail(defectDto);
			return new ResponseEntity<Object>(Constants.MAIL_SEND_SUCCESS, HttpStatus.OK);
		}
		defectService.createDefect(mapper.map(defectDto, Defect.class));
		return new ResponseEntity<Object>(Constants.DEFECT_UPDATED_SUCCESS, HttpStatus.OK);

	}

	// Delete
	@DeleteMapping(value = EndpointURI.DEFECT_BY_ID)
	public ResponseEntity<Object> deleteDefectById(@PathVariable Long id) {
		if (!defectService.existsDefectById(id)) {
			return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS_BY_ID,
					validationFailureStatusCodes.getDefectExistsById()), HttpStatus.BAD_REQUEST);
		}
		defectService.deleteDefectById(id);
		return new ResponseEntity<Object>(Constants.DEFECT_DELETED_SUCCESS, HttpStatus.OK);
	}

	// GetById
	@GetMapping(value = EndpointURI.DEFECT_BY_ID)
	public ResponseEntity<Object> findDefectByID(@PathVariable Long id) {
		if (defectService.existsDefectById(id)) {
			return new ResponseEntity<Object>(defectService.getDefectById(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationFailureResponse(ValidationConstance.DEFECT_NOT_EXISTS_BY_ID,
				validationFailureStatusCodes.getDefectExistsById()), HttpStatus.BAD_REQUEST);
	}
}