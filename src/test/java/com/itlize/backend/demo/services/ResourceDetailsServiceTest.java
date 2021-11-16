package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.entities.ResourceDetails;
import com.itlize.backend.demo.repositories.ProjectColumnRepository;
import com.itlize.backend.demo.repositories.ProjectRepository;
import com.itlize.backend.demo.repositories.ResourceRepository;
import com.itlize.backend.demo.utils.dto.ResourceDetailsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

@SpringBootTest
class ResourceDetailsServiceTest {

    @Autowired
    private ResourceDetailsService resourceDetailsService;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ProjectColumnRepository columnRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void findByResource( ) {
        Resource r = resourceRepository.findById(1).orElse(null);
        List<ResourceDetails> list = resourceDetailsService.findByResource(r);

        assertEquals(1, list.size());

    }

    @Test
    void create( ) {
        ProjectColumn pc = columnRepository.findById(1).orElse(null);
        Resource r = resourceRepository.findById(1).orElse(null);
        ResourceDetails resourceDetails = new ResourceDetails();
        resourceDetails.setColumnValue("1");
        resourceDetails.setProjectColumn(pc);
        resourceDetails.setResource(r);
        resourceDetails = resourceDetailsService.create(resourceDetails);
        assertEquals("1", resourceDetails.getColumnValue());
    }

    @Test
    void update( ) {
        ResourceDetailsDto dto = new ResourceDetailsDto();
        dto.setId(1);
        dto.setColumnValue("100");
        ResourceDetails resourceDetails = resourceDetailsService.update(dto);
        assertEquals("100", resourceDetails.getColumnValue());

    }

    @Test
    void findValue( ) {
        Resource r = resourceRepository.findById(1).orElse(null);
        Project p = projectRepository.findById(1).orElse(null);
        ResourceDetails resourceDetails = resourceDetailsService.findValue(r, p, "quantity");
        assertEquals("100", resourceDetails.getColumnValue());
    }
}