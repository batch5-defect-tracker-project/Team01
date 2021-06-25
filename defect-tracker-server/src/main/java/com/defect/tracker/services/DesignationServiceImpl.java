package com.defect.tracker.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.entities.Designation;
import com.defect.tracker.data.repositories.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {
	@Autowired
	private DesignationRepository designationRepository;

	@Override
	public boolean isDesignationNameAlreadyExist(String name) {
        return designationRepository.existsByName(name);
	}

	@Override
	public void createDesignation(Designation designation) {
		designationRepository.save(designation);
	}

	@Override
	public List<Designation> getAllDesignation() {
		return designationRepository.findAll();
	}

	@Override
	public boolean designationExistsById(Long id) {
	    return designationRepository.existsById(id);
	}

	@Override
	public void designationDeleteById(Long id) {
		designationRepository.deleteById(id);
	}

	@Override
	public Object getDesignationById(Long id) {
		return designationRepository.findById(id);
	}

	@Override
	public void editDesignationById(Designation designation) {
		designationRepository.save(designation);
	}
}

	

	

	
