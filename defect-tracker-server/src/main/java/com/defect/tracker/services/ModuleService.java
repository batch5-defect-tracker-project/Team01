package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.defect.tracker.data.entities.Module;
@Service
public interface ModuleService  {



	public void createModule(Module module);
	
	public List<Module> getAllModule();

    public void deleteById(Long id);

	public boolean existsById(Long id);

	public Object getModuleById(Long id);

	public boolean getModuleByProjectIdAndName(Long projectId, String name);

	boolean isModuleNameAlreadyExist(String name);

	public boolean existsByModuleId(Long moduleId);

	
	

	
}
