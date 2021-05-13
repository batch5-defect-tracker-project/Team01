package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Defect;
@Service
public interface DefectService {

	public boolean isModNameAlreadyExist(String modName);
	
	public void createDefect(Defect defect);
	
	public List<Defect> getAllDefect();
	
	public boolean existsById(Long id);
	
	public void editDefect (Defect defect);
	
}