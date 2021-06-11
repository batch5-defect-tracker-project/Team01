package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.repositories.DefectRepository;

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	private DefectRepository defectRepository;

	

	@Override
	public void createDefect(Defect defect) {
		defectRepository.save(defect);
		
	}
	
	@Override
	public List<Defect> getAllDefect() {
		return defectRepository.findAll();
	}

	@Override
	public boolean existsDefectById(Long id) {
		return defectRepository.existsById(id);
	}

	@Override
	public void editDefectById(Defect defect) {
		defectRepository.save(defect);
		
	}

	@Override
	public void deleteDefectById(Long id) {
		defectRepository.deleteById(id);
	}

	@Override
	public Object getDefectById(Long id) {
		return defectRepository.findById(id);
	}

	@Override
	public boolean isDefectExistsById(Long id) {
		
		return defectRepository.existsById(id);
	}


}

