package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.utils.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<Project> initData();

    Project findOneById(int id);

    List<Project> findAll();

    Project createOne(Project project, int userId);

    Project updateOneById(ProjectDto dto);

    Boolean deleteOneById(int id);

    List<Project> findAllByUserId(int id);
}
