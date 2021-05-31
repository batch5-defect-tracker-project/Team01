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

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private VerificationService verificationService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmployeeService employeeService;

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

	public void sendDefectStatusMail(DefectDto defectDto) throws MessagingException {
		Employee assignedBy = employeeService.findById(defectDto.getAssignedById());
		Employee assignedTo = employeeService.findById(defectDto.getAssignedToId());
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("meera10testmail@gmail.com");
		simpleMail.setSubject("Defect Status Update Confirmation");
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		if (defectDto.getStatus().equalsIgnoreCase("New") || defectDto.getStatus().equalsIgnoreCase("Closed")
				|| defectDto.getStatus().equalsIgnoreCase("ReOpen")) {
			simpleMail.setTo(assignedTo.getEmail());
			simpleMail.setText("Defect Status Changed To " + defectDto.getStatus() + "\n by - " + assignedBy.getName()
					+ "\n" + date + "	" + time);
		}

		if (defectDto.getStatus().equalsIgnoreCase("Open") || defectDto.getStatus().equalsIgnoreCase("Fixed")
				|| defectDto.getStatus().equalsIgnoreCase("Report")) {
			simpleMail.setTo(assignedBy.getEmail());
			simpleMail.setText("Defect Status Changed To " + defectDto.getStatus() + "\n by - " + assignedTo.getName()
					+ "\n" + date + "	" + time);
		}

		javaMailSender.send(simpleMail);
	}
}
