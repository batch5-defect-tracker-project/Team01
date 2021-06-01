package com.defect.tracker.services;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Employee;

@Service
public interface EmailService {
	public void sendMail(Employee employee) throws MessagingException;

	public void sendUpdatedMail(Employee employee) throws MessagingException;

	public void sendDefectStatusMail(DefectDto defectDto) throws MessagingException;

	public void sendDefectAddMail(DefectDto defectDto) throws MessagingException;

}
