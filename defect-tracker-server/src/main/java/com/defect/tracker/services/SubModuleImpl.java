package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.SubModule;

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
		return subModuleRepository.existsByName(name);
	}

	@Override
	public boolean exitsSubModuleById(Long id) {
		return subModuleRepository.existsById(id);
	}

	@Override

	public boolean existsById(Long id) {
		return subModuleRepository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {

		subModuleRepository.deleteById(id);		

		subModuleRepository.deleteById(id);

	}

	public SubModule getSubModuleById(Long id) {
		SubModule subModule = subModuleRepository.findById(id).get();
		System.out.println(subModule.getModule());
		return subModule;
	}


	public List<SubModule> getAllSubModule() {
		return subModuleRepository.findAll();

	}

	@Override
	public boolean existsByIdAndModuleId(Long moduleId) {
		return false;
	}

}
