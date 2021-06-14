package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Defect;
@Service
public interface DefectService {

	public boolean isDefectExistsById(Long id);
	
	public void createDefect(Defect defect);
	
	public List<Defect> getAllDefect();
	
	public boolean existsDefectById(Long id);
	
	public void editDefectById(Defect defect);
	
	public void deleteDefectById(Long id);
	
	public Object getDefectById(Long id);

	public String getDefectStatusById(Long id);
	
}