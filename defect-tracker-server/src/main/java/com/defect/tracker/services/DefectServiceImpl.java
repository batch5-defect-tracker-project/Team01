package com.defect.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.dto.DefectCountByPriotryAndProjectDto;
import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.entities.Project;
import com.defect.tracker.data.repositories.DefectRepository;

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	private DefectRepository defectRepository;

	@Autowired
	private ProjectService projectService;

	@Override
	public void createDefect(Defect defect) {
		defectRepository.save(defect);
	}

	@Override
	public List<Defect> getAllDefect() {
		return defectRepository.findAll();
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
	public DefectCountByPriotryAndProjectDto countByProject(String projectName) {
		Project project = projectService.findByName(projectName);
		DefectCountByPriotryAndProjectDto defectCountDto = new DefectCountByPriotryAndProjectDto();
		defectCountDto.setPriorityHigh(defectRepository.countByPriorityAndProject("high", project));
		defectCountDto.setPriorityMedium(defectRepository.countByPriorityAndProject("medium", project));
		defectCountDto.setPriorityLow(defectRepository.countByPriorityAndProject("low", project));
		defectCountDto.setSeverityHigh(defectRepository.countBySeverityAndProject("high", project));
		defectCountDto.setSeverityMedium(defectRepository.countBySeverityAndProject("medium", project));
		defectCountDto.setSeverityLow(defectRepository.countBySeverityAndProject("low", project));
		defectCountDto.setPrioritySeverityHigh(
				defectRepository.countByPriorityAndSeverityAndProject("high", "high", project));
		defectCountDto.setTotalDefect(defectRepository.countByProject(project));
		return defectCountDto;
	}

}
