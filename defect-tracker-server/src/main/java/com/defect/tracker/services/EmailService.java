package com.defect.tracker.services;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Employee;

@Service
public interface EmailService {
	public void sendEmployeeRegisteredMail(Employee employee) throws MessagingException;

	public void sendEmployeeUpdatedMail(Employee employee) throws MessagingException;

}
