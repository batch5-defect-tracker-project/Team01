package com.defect.tracker.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.defect.tracker.data.dto.DefectStatusCountDto;
import com.defect.tracker.data.entities.Defect;
import com.defect.tracker.data.entities.Project;
import com.defect.tracker.data.mapper.Mapper;
import com.defect.tracker.data.repositories.DefectRepository;

@Service
public class DefectServiceImpl implements DefectService {

	@Autowired
	private DefectRepository defectRepository;

	@Autowired
	ProjectService projectService;

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
	public Object getDefectStatusById(Long id) {
		return defectRepository.findById(id).get().getStatus();
	}

	@Override
	public DefectStatusCountDto getDefectCount(String projectName) {
		Project project = projectService.findProjectByName(projectName);
		DefectStatusCountDto defectCount = new DefectStatusCountDto();
		defectCount.setOpen(defectRepository.countByStatusAndProject("open", project));
		defectCount.setClosed(defectRepository.countByStatusAndProject("closed", project));
		defectCount.setReject(defectRepository.countByStatusAndProject("reject", project));
		defectCount.setReopen(defectRepository.countByStatusAndProject("reopen", project));
		defectCount.setFixed(defectRepository.countByStatusAndProject("fixed", project));
		defectCount.setNew(defectRepository.countByStatusAndProject("new", project));
		return defectCount;
	}

	@Override
	public boolean existsstatus(String status) {
		return defectRepository.existsByStatus(status);
	}

}
