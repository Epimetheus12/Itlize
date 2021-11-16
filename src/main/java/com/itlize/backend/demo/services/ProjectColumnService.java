package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.utils.dto.ProjectColumnDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectColumnService {

    ProjectColumn findOneById(int id);

    List<ProjectColumn> findByProject(Project project);

    ProjectColumn addNewColumn(ProjectColumn projectColumn);

    ProjectColumn updateColumn(ProjectColumnDto dto);

    Boolean deleteColumn(ProjectColumn projectColumn);
}
