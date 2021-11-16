package com.itlize.backend.demo.utils;

import com.itlize.backend.demo.entities.*;
import com.itlize.backend.demo.repositories.ProjectRepository;
import com.itlize.backend.demo.repositories.ResourceRepository;
import com.itlize.backend.demo.repositories.UserRepository;
import com.itlize.backend.demo.services.ProjectResourceService;
import com.itlize.backend.demo.services.ProjectService;
import com.itlize.backend.demo.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class Seed {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ResourceRepository resourceRepository;
    private final ProjectService projectService;
    private final ResourceService resourceService;
    private final ProjectResourceService projectResourceService;

    @Autowired
    public Seed(UserRepository userRepository, ProjectRepository projectRepository, ResourceRepository resourceRepository, ProjectService projectService, ResourceService resourceService, ProjectResourceService projectResourceService) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.resourceRepository = resourceRepository;
        this.projectService = projectService;
        this.resourceService = resourceService;
        this.projectResourceService = projectResourceService;
    }

    @PostConstruct
    public void initializeData(){
        User u1 = userRepository.findById(1).orElse(null);
        User u2 = userRepository.findById(2).orElse(null);

        if(u1 == null || u2 == null){
            u1 = new User();
            u2 = new User();
            u1.setUsername("user1");
            u1.setPassword("secret");
            u1.setFirstName("user1_first");
            u1.setLastName("user1_last");
            u1.setRole(Role.root);
            u1.setPhone("123456");
            u1.setEmail("u1@email.com");
//            u1.setCreatedTime(new Timestamp(new Date().getTime()));

            u2.setUsername("user2");
            u2.setPassword("secret");
            u2.setFirstName("user2_first");
            u2.setLastName("user2_last");
            u2.setRole(Role.admin);
            u2.setPhone("123456");
            u2.setEmail("u2@email.com");
//            u2.setCreatedTime(new Timestamp(new Date().getTime()));
            userRepository.save(u1);
            userRepository.save(u2);

            Project p1 = projectRepository.findById(1).orElse(null);
            Project p2 = projectRepository.findById(2).orElse(null);
            if(p1 == null || p2 == null){
                projectService.initData();
            }

            Resource r1 = resourceRepository.findById(1).orElse(null);
            Resource r2 = resourceRepository.findById(2).orElse(null);
            if(r1 == null || r2 == null){
                resourceService.initData();
            }

            projectResourceService.updateRelationship(1, 1);
            projectResourceService.updateRelationship(1, 2);
        }
    }
}
