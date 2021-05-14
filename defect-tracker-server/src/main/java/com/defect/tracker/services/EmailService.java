package com.defect.tracker.services;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Employee;

@Service
public interface EmailService {
	public void sendMail(Employee employee) throws MessagingException;
}
