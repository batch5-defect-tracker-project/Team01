package com.defect.tracker.services;

import javax.mail.MessagingException;

import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Employee;

public interface EmailService {
	public void sendEmployeeRegisteredMail(Employee employee) throws MessagingException;

	public void sendEmployeeUpdatedMail(Employee employee) throws MessagingException;

	public void sendDefectStatusAddEmail(DefectDto defectDto);

	public void sendDefectStatusUpdateEmail(DefectDto defectDto);

}
