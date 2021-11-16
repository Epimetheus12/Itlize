package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectResource;
import com.itlize.backend.demo.entities.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectResourceServiceTest {

    @Autowired
    private ProjectResourceService projectResourceService;

    @Test
    void findProjectByResource( ) {
        List<Project> res = projectResourceService.findProjectByResource(1);
        assertEquals(1, res.get(0).getId());
    }

    @Test
    void findResourceByProject( ) {
        List<Resource> res = projectResourceService.findResourceByProject(1);
        assertEquals(1, res.get(0).getId());
        assertEquals(2, res.get(1).getId());
    }

    @Test
    void updateRelationship( ) {
        Boolean pr1 = projectResourceService.updateRelationship(1, 1);
        Boolean pr2 = projectResourceService.updateRelationship(1, 2);

        assertEquals(true, pr1);
        assertEquals(true, pr2);
    }

//    @Test
//    void deleteRelationshipByResource( ) {
//        Boolean res = projectResourceService.deleteRelationshipByResource(5);
//
//        assertEquals(true, res);
//    }
//
//    @Test
//    void deleteRelationshipByProject( ) {
//        Boolean res = projectResourceService.deleteRelationshipByProject(3);
//
//        assertEquals(true, res);
//    }
}