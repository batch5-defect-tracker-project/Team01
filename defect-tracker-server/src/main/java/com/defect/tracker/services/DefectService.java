package com.defect.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DefectDto;
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
	
	public List<Long> getDefectStatus(Long id);
	
	public Object getDefectStatusById(Long id);
	
	public boolean existsAssignedTo(Long id);
	
	public boolean existsModuleId(Long id);
	
	public boolean existsAssignedBy(Long id);
	
	public Long getDefectCount(Long id,String status);
}