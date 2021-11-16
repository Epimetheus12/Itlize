package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectResource;
import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.repositories.ProjectRepository;
import com.itlize.backend.demo.repositories.ProjectResourceRepository;
import com.itlize.backend.demo.repositories.ResourceRepository;
import com.itlize.backend.demo.services.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    private final ProjectRepository projectRepository;
    private final ResourceRepository resourceRepository;
    private final ProjectResourceRepository projectResourceRepository;

    @Autowired
    public ProjectResourceServiceImpl(ProjectRepository projectRepository, ResourceRepository resourceRepository, ProjectResourceRepository projectResourceRepository) {
        this.projectRepository = projectRepository;
        this.resourceRepository = resourceRepository;
        this.projectResourceRepository = projectResourceRepository;
    }

    @Override
    public List<Project> findProjectByResource(int id) {
        List<Integer> ids = projectResourceRepository.findAllProjectIdByResourceId(id);

        return projectRepository.findAllById(ids);

//        Resource resource = resourceRepository.findById(id).orElse(null);
//        assert resource != null;
//        List<ProjectResource> res = resource.getProjectResourceList();
//        List<Resource> r = res.stream().
//                map(ProjectResource::getResource).
//                collect(Collectors.toList());
    }

    @Override
    public List<Resource> findResourceByProject(int id) {
        List<Integer> ids = projectResourceRepository.findAllResourceIdByProjectId(id);

        return resourceRepository.findAllById(ids);

    }

    @Override
    @Transactional
    public Boolean updateRelationship(int p_id, int r_id) {
        if(projectResourceRepository.existsDistinctByProject_IdAndResource_Id(p_id, r_id)) return true;

        Project project = projectRepository.findById(p_id).orElse(null);
        Resource resource = resourceRepository.findById(r_id).orElse(null);
        if(project != null && resource != null){
            ProjectResource projectResource = new ProjectResource();
            projectResource.setProject(project);
            projectResource.setResource(resource);
            projectResourceRepository.save(projectResource);
            return true;
        }
        return false;
    }

//    @Override
//    public Boolean deleteRelationshipByResource(int id) {
//        projectResourceRepository.deleteAllByResource_Id(id);
//        return !projectResourceRepository.existsAllByResource_Id(id);
//    }
//
//    @Override
//    public Boolean deleteRelationshipByProject(int id) {
//        projectResourceRepository.deleteAllByProject_Id(id);
//        return !projectResourceRepository.existsAllByProject_Id(id);
//    }


}
