package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.defect.tracker.data.entities.Module;

@Service
public interface ModuleService {

	public void createModule(Module module);

	public List<Module> getAllModule();

	public void deleteById(Long id);

	void updateModule(Module module);

	public Object getModuleById(Long id);

	public boolean getModuleByProjectIdAndName(Long projectId, String name);

	boolean isModuleNameAlreadyExist(String name);

	boolean existsById(Long id);

	public Object findById(Long id);

	public boolean existsModuleById(Long id);

}
