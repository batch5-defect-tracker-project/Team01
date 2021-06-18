package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;




import com.defect.tracker.data.entities.SubModule;

@Service
public interface SubModuleService {

	public boolean subModuleExits(String name);

	public void createSubModule(SubModule subModule);

	public boolean exitsSubModuleById(Long id);

	public boolean isSubModuleNameAlreadyExist(String name);
	
	public SubModule getSubModuleById(Long id);

	public List<SubModule> getAllSubModule();

	public boolean existsById(Long id);

	public void deleteById(Long id);

	public boolean getModuleIdAndName(Long moduleId, String name);

	public boolean existsByIdAndModuleId(Long subModuleId, Long moduleId);

}
