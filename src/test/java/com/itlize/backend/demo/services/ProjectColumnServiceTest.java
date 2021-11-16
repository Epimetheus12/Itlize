package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.entities.Type;
import com.itlize.backend.demo.repositories.ProjectRepository;
import com.itlize.backend.demo.repositories.ResourceRepository;
import com.itlize.backend.demo.utils.dto.ProjectColumnDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectColumnServiceTest {



    @Autowired
    private ProjectColumnService projectColumnService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourceRepository resourceRepository;

//    @Test
//    void addNewColumn( ) {

//        ProjectColumn pc1 = new ProjectColumn();
//        Project project = projectRepository.findById(1).orElse(null);
//        Resource resource = resourceRepository.findById(1).orElse(null);
//        pc1.setColumnName("quantity");
//        pc1.setContent("10");
//        pc1.setType(Type.number);
//        pc1.setProject(project);
//        pc1.setResource(resource);
//        pc1.setCreatedTime(new Timestamp(new Date().getTime()));
//        pc1.setUpdatedTime(new Timestamp(new Date().getTime()));
//
//
//        projectColumnService.addNewColumn(pc1);
//
//        System.out.println(resourceRepository.findAll());
//    }

    @Test
    void findOneById( ) {
        ProjectColumn projectColumn = projectColumnService.findOneById(1);
        assertEquals(1, projectColumn.getId());
    }

    @Test
    void findByProject( ) {
        Project project = projectRepository.findById(1).orElse(null);
        List<ProjectColumn> list = projectColumnService.findByProject(project);
        assertEquals(2, list.size());
    }

    @Test
    void addNewColumn( ) {
        Project project = projectRepository.findById(1).orElse(null);
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setType(Type.number);
        projectColumn.setColumnName("quantity");
        projectColumn.setProject(project);
        ProjectColumn pc2 = new ProjectColumn();
        pc2.setProject(project);
        pc2.setType(Type.number);
        pc2.setColumnName("price");
        pc2.setProject(project);
        projectColumn =projectColumnService.addNewColumn(projectColumn);
        pc2 = projectColumnService.addNewColumn(pc2);
        assertEquals("quantity", projectColumn.getColumnName());

    }

    @Test
    void updateColumn( ) {
        ProjectColumnDto dto = new ProjectColumnDto();
        dto.setId(2);
        dto.setColumnName("test_price");
        ProjectColumn projectColumn = projectColumnService.updateColumn(dto);
        assertEquals("test_price", projectColumn.getColumnName());
    }

    @Test
    void deleteColumn( ) {
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn = projectColumnService.addNewColumn(projectColumn);
        Boolean res = projectColumnService.deleteColumn(projectColumn);
        assertEquals(true, res);
    }
}