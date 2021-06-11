package com.defect.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.SubModule;
import com.defect.tracker.data.repositories.ModuleRepository;
import com.defect.tracker.data.repositories.SubModuleRepository;

@Service
public class SubModuleImpl implements SubModuleService {

	@Autowired
	private SubModuleRepository subModuleRepository;
	

	@Override
	public void createSubModule(SubModule subModule) {
		subModuleRepository.save(subModule);
		}

	@Override
	public boolean isSubModuleNameAlreadyExist(String name) {
		
		return  subModuleRepository.existsByName(name) ;
		}

	@Override
	public boolean exitsSubModuleById(Long id) {
	
		return subModuleRepository.existsById(id);
	}

	@Override
	public boolean getModuleIdAndName(Long moduleId, String name) {
		
		return subModuleRepository.existsByModuleIdAndName(moduleId,name);
	}

}
