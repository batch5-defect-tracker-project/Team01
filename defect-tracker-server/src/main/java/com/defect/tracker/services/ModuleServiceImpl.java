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
	public boolean isModuleNameAlreadyExist(String name) {
		return moduleRepository.existsByName(name);
	}

	@Override
	public List<Module> getAllModule() {
		return moduleRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		moduleRepository.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return moduleRepository.existsById(id);
	}

	@Override
	public Object getModuleById(Long id) {
		return moduleRepository.findById(id).get();
	}

	@Override
	public boolean getModuleByProjectIdAndName(Long projectId, String name) {
		return moduleRepository.existsByProjectIdAndName(projectId, name);
	}

	@Override
	public Object findById(Long id) {
		return moduleRepository.findById(id).get().getName();
	}

	@Override
	public boolean existsModuleById(Long id) {
		return moduleRepository.existsById(id);
	}

	public boolean existsByModuleId(Long moduleId) {
		return moduleRepository.existsById(moduleId);
	}

	@Override
	public boolean exsistByModuleId(Long moduleId) {
		return moduleRepository.existsById(moduleId);
	}

	@Override
	public void updateModule(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public boolean exitsModuleById(Long id) {
		return moduleRepository.existsById(id);
	}

}
