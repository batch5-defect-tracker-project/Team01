package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Module;
import com.defect.tracker.data.repositories.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public void createModule(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public boolean exitsById(Long id) {
		return moduleRepository.existsById(id);
	}

	@Override
	public boolean isModuleNameAlreadyExist(String name) {
		return moduleRepository.existsByName(name);
	}

	@Override
	public boolean moduleExits(String name) {
		// TODO Auto-generated method stub
		return moduleRepository.existsByName(name);
	}

	@Override
	public void updateModule(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public List<Module> getAllModule() {

		return moduleRepository.findAll();
	}

}
