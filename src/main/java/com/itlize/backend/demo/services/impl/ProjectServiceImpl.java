package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.entities.User;
import com.itlize.backend.demo.repositories.ProjectRepository;
import com.itlize.backend.demo.repositories.UserRepository;
import com.itlize.backend.demo.services.ProjectService;
import com.itlize.backend.demo.utils.dto.ProjectDto;
import com.itlize.backend.demo.utils.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper mapper = ProjectMapper.INSTANCE;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<Project> initData( ) {
        Project p1 = new Project();
        p1.setName("p1");
        p1.setProjectCode("1");
//        p1.setCreatedTime(new Timestamp(new Date().getTime()));
        User user1 = userRepository.findById(1).orElse(null);
        p1.setUser(user1);

        Project p2 = new Project();
        p2.setName("p2");
        p2.setProjectCode("2");
//        p2.setCreatedTime(new Timestamp(new Date().getTime()));
        User user2 = userRepository.findById(2).orElse(null);
        p2.setUser(user2);

        p1 = projectRepository.save(p1);
        p2 = projectRepository.save(p2);

        return projectRepository.findAllById(Arrays.asList(p1.getId(), p2.getId()));
    }

    @Override
    public Project findOneById(int id) {

        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> findAll( ) {

        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public Project createOne(Project project, int userId) {
        User user = userRepository.findById(userId).orElse(null);
        project.setUser(user);
        return projectRepository.save(project);
    }

    @Override
    public Project updateOneById(ProjectDto dto) {
        Project project = projectRepository.findById(dto.getId()).orElse(null);
        assert project != null;
        mapper.updateProjectFromDto(dto, project);
        return projectRepository.save(project);
    }

    @Override
    public Boolean deleteOne(Project project) {
        projectRepository.delete(project);
        return !projectRepository.exists(Example.of(project));
    }

    @Override
    public List<Project> findAllByUserId(int id) {
        return projectRepository.findAllByUser_Id(id);
    }

}
