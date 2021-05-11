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
	public boolean isModNameAlreadyExist(String modName){
		return defectRepository.existsByModuleName(modName);
	}

	@Override
	public void createDefect(Defect defect) {
		defectRepository.save(defect);
		
	}
	
	@Override
	public List<Defect> getAllDefect() {
		return defectRepository.findAll();
	}

	
}

