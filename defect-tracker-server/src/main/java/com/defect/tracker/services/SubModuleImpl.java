package com.defect.tracker.services;

import java.util.List;

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
	public boolean subModuleExits(String name) {
		
		return subModuleRepository.existsByName(name);
	}

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
	public List<SubModule> getAllSubModule() {
		return subModuleRepository.findAll();
	}

}
