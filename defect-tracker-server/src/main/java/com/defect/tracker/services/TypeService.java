package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Type;

@Service
public interface TypeService {

	public boolean isNameAlreadyExists(String name);

	public void createType(Type type);

	public List<Type> getType();

	public boolean typeExistsById(Long id);

	public void typeDeleteById(Long id);

	public Object getTypeById(Long id);

}
