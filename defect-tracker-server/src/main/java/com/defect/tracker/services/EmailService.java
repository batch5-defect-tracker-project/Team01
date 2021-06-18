package com.defect.tracker.services;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Employee;


public interface EmailService {
	public void sendMail(Employee employee) throws MessagingException;

	public void sendUpdatedMail(Employee employee) throws MessagingException;
	
	public void sendDefectStatusAddEmail(DefectDto defectDto);
	
	public void sendDefectStatusUpdateEmail(DefectDto defectDto);
	
}
