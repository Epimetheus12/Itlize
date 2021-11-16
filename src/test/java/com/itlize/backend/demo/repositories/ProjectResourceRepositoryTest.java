package com.itlize.backend.demo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component

@SpringBootTest
class ProjectResourceRepositoryTest {

    @Autowired
    private ProjectResourceRepository repository;

    @Test
    void findByProject_IdAndResource_Id( ) {
//        repository.findByProject_IdAndResource_Id();
    }
}