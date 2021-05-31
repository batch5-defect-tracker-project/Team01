package com.defect.tracker.services;

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

}
