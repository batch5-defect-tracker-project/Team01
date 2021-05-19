package com.defect.tracker.services;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Type;

@Service
public interface TypeService {
	
	public boolean isNameAlreadyExists(String name);
	
	public void createType(Type type);

}
