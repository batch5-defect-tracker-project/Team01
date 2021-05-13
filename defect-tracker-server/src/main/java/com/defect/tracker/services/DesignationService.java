package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Designation;

@Service
public interface DesignationService {
	
    public boolean isDesigNameAlreadyExist(String name);
	
	public void createDesignation(Designation designation);
	
	public List <Designation> getAllDesignation();
	
	public boolean designationExistsById(Long id);
	
	public void  designationDeleteById(Long id);
	
	public Object getDesignationById(Long id);
	
	public void editDesignationById(Designation designation);

}
