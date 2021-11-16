package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.utils.dto.ProjectDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private static ProjectRepository projectRepository;


    @Before
    public void setUp( ) {
        projectService.initData();
    }

    @Test
    void findOneById( ) {
        Project res = projectService.findOneById(1);

        assertEquals("p1", res.getName());
        assertEquals("1", res.getProjectCode());
        assertEquals(1, res.getUser().getId());
    }

    @Test
    void findAll( ) {
        List<Project> res = projectService.findAll();
        assertEquals(1, res.get(0).getId());
    }

    @Test
    void createOne( ) {
        Project p = new Project();
        p.setName("p3");
        p.setProjectCode("3");
        Project res = projectService.createOne(p, 1);

        assertEquals("p3", res.getName());
        assertEquals("3", res.getProjectCode());
        assertEquals(1, res.getUser().getId());
    }

    @Test
    void updateOneById( ) {
        ProjectDto dto = new ProjectDto();
        dto.setId(2);
        dto.setName("change_2");
//        dto.setUpdatedTime(new Timestamp(new Date().getTime()));
        Project res = projectService.updateOneById(dto);
        assertEquals("change_2", res.getName());
        assertEquals("2", res.getProjectCode());
    }

    @Test
    void deleteOneById( ) {
        Project p = new Project();
        p = projectService.createOne(p, 1);
        assertEquals(true, projectService.deleteOne(p));
    }

    @Test
    void findAllByUserId( ) {
        List<Project> res = projectService.findAllByUserId(1);
        assertEquals(1, res.get(0).getId());
    }


}