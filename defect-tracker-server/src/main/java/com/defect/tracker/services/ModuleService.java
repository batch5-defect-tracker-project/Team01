package com.defect.tracker.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.entities.Module;

@Service
public interface ModuleService {

	public boolean isModuleNameAlreadyExist(String name);

	public void createModule(Module module);

	public boolean moduleExits(String name);

	void updateModule(Module module);

	public void deleteById(Long id);

	public Object getModuleById(Long id);

	boolean existsById(Long id);

	List<Module> getAllModule();
	
	public List<Long> getProjectId(String name);
	
	public Object getModuleName(Long id);
	
	public Object getModuleId(Long id);
	
	public Object findById(Long id);
	
	public boolean existsModuleById(Long id);
	
	public boolean getModuleByProjectIdAndName(Long projectId, String name);

}
