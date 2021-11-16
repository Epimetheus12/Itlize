package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.repositories.ProjectColumnRepository;
import com.itlize.backend.demo.services.ProjectColumnService;
import com.itlize.backend.demo.utils.dto.ProjectColumnDto;
import com.itlize.backend.demo.utils.mapper.ProjectColumnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectColumnServiceImpl implements ProjectColumnService {

    private final ProjectColumnRepository repository;
    private final ProjectColumnMapper mapper = ProjectColumnMapper.INSTANCE;
    @Autowired
    public ProjectColumnServiceImpl(ProjectColumnRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectColumn findOneById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectColumn> findByProject(Project project) {
        return repository.findByProject(project);
    }

    @Override
    public ProjectColumn addNewColumn(ProjectColumn projectColumn) {
        ProjectColumn exist = repository.findByProjectAndColumnNameAndTypeAndFormula(
                projectColumn.getProject(),
                projectColumn.getColumnName(),
                projectColumn.getType(),
                projectColumn.getFormula());
        if(exist != null) return exist;

        return repository.save(projectColumn);
    }

    @Override
    public ProjectColumn updateColumn(ProjectColumnDto dto) {
        ProjectColumn pc = repository.findById(dto.getId()).orElse(null);
        assert pc != null;
        mapper.updateProjectColumnFromDto(dto, pc);
        return repository.save(pc);
    }

    @Override
    public Boolean deleteColumn(ProjectColumn projectColumn) {
        repository.delete(projectColumn);
        return !repository.exists(Example.of(projectColumn));
    }
}
