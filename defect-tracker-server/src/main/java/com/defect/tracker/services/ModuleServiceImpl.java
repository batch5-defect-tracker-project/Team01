package com.defect.tracker.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.ModuleDto;
import com.defect.tracker.data.entities.Module;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	Mapper mapper;
	
	@Override
	public void createModule(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public boolean isModuleNameAlreadyExist(String name) {
		return moduleRepository.existsByName(name);
	}

	@Override
	public List<Long> getProjectId(String name) {
		List<Module> module = moduleRepository.findAll();
		return module.stream().map(this::projectIdGet).collect(Collectors.toList());
	}

	public Long projectIdGet(Module module) {
		ModuleDto moduleDto = mapper.map(module, ModuleDto.class);
		return moduleDto.getProjectId();
	}
	
	@Override
	public boolean moduleExits(String name) {

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

	@Override
	public void deleteById(Long id) {
		moduleRepository.deleteById(id);

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

	public boolean existsById(Long id) {
		return moduleRepository.existsById(id);
	}

	@Override

	public Object getModuleById(Long id) {
		return moduleRepository.findById(id);
	}

	@Override
	public Object getModuleName(Long id) {
		return moduleRepository.findById(id).get().getName();
	}

	@Override
	public Object getModuleId(Long id) {
		return moduleRepository.findById(id).get().getProjectId();
	}

}
