package com.defect.tracker.services;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;
import com.defect.tracker.data.mapper.Mapper;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private VerificationService verificationService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	Mapper mapper;

	@Autowired
	ModuleService moduleService;

	@Autowired
	ProjectService projectService;

	@Override
	public void sendMail(Employee employee) throws MessagingException {
		VerificationToken verificationToken = verificationService.findByEmployee(employee);
		if (verificationToken != null) {
			String token = verificationToken.getToken();
			SimpleMailMessage simpleMail = new SimpleMailMessage();
			simpleMail.setFrom("meera10testmail@gmail.com");
			simpleMail.setTo(employee.getEmail());
			simpleMail.setSubject("Email Verification");
			simpleMail.setText(
					"please click the link for verify the account \n http://localhost:1726/defect-tracker/api/v1/employee/activation?token="
							+ token);
			javaMailSender.send(simpleMail);
		}
	}

	@Override
	public void sendUpdatedMail(Employee employee) throws MessagingException {
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("meera10testmail@gmail.com");
		simpleMail.setTo(employee.getEmail());
		simpleMail.setSubject("Employee Details Update Confirmation");
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		simpleMail.setText("Your details update successful when " + date + "	" + time);
		javaMailSender.send(simpleMail);

	}

	@Override
	public void sendDefectStatusChangeEmail(DefectDto defectDto) {
		Employee assignBy = mapper.map(employeeService.findEmployeeById(defectDto.getAssignedById()), Employee.class);
		Employee assignTo = mapper.map(employeeService.findEmployeeById(defectDto.getAssignedToId()), Employee.class);

		SimpleMailMessage mailmessage = new SimpleMailMessage();
		mailmessage.setFrom("meera10testmail@gmail.com");
		if ((defectDto.getStatus().equals("reopen")) || (defectDto.getStatus().equals("closed"))
				|| (defectDto.getStatus().equals("open"))) {
			mailmessage.setTo(assignBy.getEmail());
		} else if ((defectDto.getStatus().equals("new")) || (defectDto.getStatus().equals("fixed"))
				|| (defectDto.getStatus().equals("reject"))) {
			mailmessage.setTo(assignTo.getEmail());
		}
		mailmessage.setSubject(defectDto.getStatus());
		mailmessage.setText("assigenedToEmployeeId=>" + defectDto.getAssignedToId() + "  moduleName=>"
				+ moduleService.getModuleName(defectDto.getModuleId()) + "  projectName=>"
				+ projectService.getProjectByName((Long) moduleService.getModuleId(defectDto.getModuleId())));
		javaMailSender.send(mailmessage);

	}

}
