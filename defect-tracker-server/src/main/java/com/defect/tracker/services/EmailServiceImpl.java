package com.defect.tracker.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	public void sendEmployeeRegisteredMail(Employee employee) throws MessagingException {
		VerificationToken verificationToken = verificationService.findByEmployee(employee);
		if (verificationToken != null) {
			String token = verificationToken.getToken();
			String url = "http://localhost:1726/defect-tracker/api/v1/employee/activation?token=" + token;
			String content = "<center><p>Dear " + employee.getName() + " ,</p></center>";
			content += "<center><h1><p>Please verify your account </p></h1></center>";
			content += "<center><h2><a href=\"" + url + "\">VERIFY</a></h2></center>";
			content += "<center><p> Thank You .</p></center>";
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("meera10testmail@gmail.com");
			mimeMessageHelper.setTo(employee.getEmail());
			mimeMessageHelper.setSubject("Email Verification");
			mimeMessageHelper.setSentDate(new Date());
			mimeMessageHelper.setText(content, true);
			javaMailSender.send(mimeMessage);
		}
	}

	@Override
	public void sendEmployeeUpdatedMail(Employee employee) throws MessagingException {
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("meera10testmail@gmail.com");
		simpleMail.setTo(employee.getEmail());
		simpleMail.setSubject("Employee Details Update Confirmation");
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		simpleMail.setText("Your details update successful when " + date + "	" + time);
		javaMailSender.send(simpleMail);

	}

	public void sendDefectAddMail(DefectDto defectDto) throws MessagingException {
		Employee assignedBy = employeeService.findById(defectDto.getAssignedById());
		Employee assignedTo = employeeService.findById(defectDto.getAssignedToId());
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("meera10testmail@gmail.com");
		simpleMail.setSubject("New Defect Addedd");
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		simpleMail.setTo(assignedTo.getEmail());
		simpleMail.setText("New Defect Added to you \n by - " + assignedBy.getName() + "\n" + date + "	" + time);
		javaMailSender.send(simpleMail);
	}

	public void sendDefectStatusUpdatedMail(DefectDto defectDto) throws MessagingException {
		Employee assignedBy = employeeService.findById(defectDto.getAssignedById());
		Employee assignedTo = employeeService.findById(defectDto.getAssignedToId());
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("meera10testmail@gmail.com");
		simpleMail.setSubject("Defect Status Update Confirmation");
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		if (defectDto.getStatus().equalsIgnoreCase("Closed") || defectDto.getStatus().equalsIgnoreCase("ReOpen")) {
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
