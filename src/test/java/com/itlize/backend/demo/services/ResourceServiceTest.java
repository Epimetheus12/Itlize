package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.utils.dto.ResourceDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;


    @Test
    void findOneById( ) {
        Resource res = resourceService.findOneById(1);

        assertEquals("r1", res.getName());
        assertEquals("1", res.getResourceCode());

    }

    @Test
    void findAll( ) {
        List<Resource> res = resourceService.findAll();
        assertEquals(1, res.get(0).getId());
    }

    @Test
    void createOne( ) {
        Resource r = new Resource();
        r.setName("r3");
        r.setResourceCode("3");
        Resource res = resourceService.createOne(r);

        assertEquals("r3", res.getName());
        assertEquals("3", res.getResourceCode());
    }

    @Test
    void updateOneById( ) {
        ResourceDto dto = new ResourceDto();
        dto.setId(2);
        dto.setName("change_2");
//        dto.setUpdatedTime(new Timestamp(new Date().getTime()));
        Resource res = resourceService.updateOneById(dto);
        assertEquals("change_2", res.getName());
        assertEquals("2", res.getResourceCode());
    }

    @Test
    void deleteOneById( ) {
        Resource r = new Resource();
        r = resourceService.createOne(r);
        assertEquals(true, resourceService.deleteOne(r));
    }
}