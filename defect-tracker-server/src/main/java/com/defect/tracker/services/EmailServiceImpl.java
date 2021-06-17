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

import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.entities.VerificationToken;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private VerificationService verificationService;

	@Autowired
	private JavaMailSender javaMailSender;

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
}
