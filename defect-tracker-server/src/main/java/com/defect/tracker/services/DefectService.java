package com.defect.tracker.services;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Defect;
@Service
public interface DefectService {

	public boolean isModNameAlreadyExist(String modName);
	
	public void createDefect(Defect defect);
	
}