package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Type;
import com.defect.tracker.data.repositories.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	@Override
	public boolean isNameAlreadyExists(String name) {
		return typeRepository.existsByName(name);
	}

	@Override
	public void createType(Type type) {
		typeRepository.save(type);
		
	}

	@Override
	public void editTypeById(Type type) {
		typeRepository.save(type);
		
	}

	@Override
	public boolean typeIdExists(Long id) {
		return typeRepository.existsById(id);
	}

	@Override
	public void deleteTypeById(Long id) {
		typeRepository.deleteById(id);
		
}
	@Override
	public List<Type> getType() {
		return typeRepository.findAll();
	}

}
