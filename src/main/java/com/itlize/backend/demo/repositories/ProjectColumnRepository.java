package com.itlize.backend.demo.repositories;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Integer> {
    ProjectColumn findByProjectAndColumnNameAndTypeAndFormula(Project project, String columnName, Type type, String formula);
    List<ProjectColumn> findByProject(Project project);
}
