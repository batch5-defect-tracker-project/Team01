package com.defect.tracker.services;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.SubModule;
@Service
public interface SubModuleService {

	public  boolean subModuleExits(String name);

	public void createSubModule(SubModule subModule);

	public boolean exitsSubModuleById(Long id);

	public boolean isSubModuleNameAlreadyExist(String name);

	public boolean getModuleIdAndName(Long moduleId, String name);

}
