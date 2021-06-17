package com.defect.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.Type;

@Service
public interface TypeService {

	public boolean isNameAlreadyExists(String name);

	public void createType(Type type);

	public void editTypeById(Type type);

	public boolean typeIdExists(Long id);

	public void deleteTypeById(Long id);

	public List<Type> getType();

	public Object getTypeById(Long id);

}
