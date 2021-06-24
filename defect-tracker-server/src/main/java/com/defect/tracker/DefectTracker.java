package com.defect.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DefectTracker {

	public static void main(String[] args) {
		SpringApplication.run(DefectTracker.class, args);
	}

}
