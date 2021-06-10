package com.defect.tracker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DefectDto;
import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.DefectRepository;

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	private DefectRepository defectRepository;

	@Autowired
	Mapper mapper;

	@Override
	public void createDefect(Defect defect) {
		defectRepository.save(defect);

	}

	@Override
	public List<Defect> getAllDefect() {
		return (List<Defect>) defectRepository.findAll();
	}

	@Override
	public boolean existsDefectById(Long id) {
		return defectRepository.existsById(id);
	}

	@Override
	public void editDefectById(Defect defect) {
		defectRepository.save(defect);

	}

	@Override
	public void deleteDefectById(Long id) {
		defectRepository.deleteById(id);
	}

	@Override
	public Object getDefectById(Long id) {
		return defectRepository.findById(id);
	}

	@Override
	public boolean isDefectExistsById(Long id) {

		return defectRepository.existsById(id);
	}

	@Override
	public List<Long> getDefectStatus(Long id) {
		List<Defect> defect = defectRepository.findByProjectId(id);
		return defect.stream().map(this::statusCount).collect(Collectors.toList());
		
	}

	public Long statusCount(Defect defect) {
		DefectDto defectDto = mapper.map(defect, DefectDto.class);
		 return defectDto.getId();
	}

	@Override
	public Object getDefectStatusById(Long id) {
		return defectRepository.findById(id).get().getStatus();
	}

	@Override
	public boolean existsAssignedTo(Long id) {
		return defectRepository.existsByAssignedToId(id);
	}

	@Override
	public boolean existsModuleId(Long id) {
		return defectRepository.existsByModuleId(id);
	}

	@Override
	public boolean existsAssignedBy(Long id) {
		return defectRepository.existsByAssignedById(id);
	}

	@Override
	public Long getDefectCount(Long id,String status) {
		return defectRepository.countByIdAndStatus(id,status);
	}

}
