package com.itlize.backend.demo.controllers;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.services.ProjectResourceService;
import com.itlize.backend.demo.services.ProjectService;
import com.itlize.backend.demo.utils.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectResourceService projectResourceService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectResourceService projectResourceService) {
        this.projectService = projectService;
        this.projectResourceService = projectResourceService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> allProjectByUserId() {
        return new ResponseEntity< >(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all/")
    public ResponseEntity<?> allProjectsByUserId(@RequestParam("id") int id) {
        return new ResponseEntity< >(projectService.findAllByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> projectById(@RequestParam("id") int id) {
        return new ResponseEntity< >(projectService.findOneById(id), HttpStatus.OK);
    }

    @GetMapping("/delete/")
    public ResponseEntity<?> deleteById(@RequestParam("id") int id){
        return new ResponseEntity< >(projectService.deleteOneById(id), HttpStatus.OK);
    }

    @GetMapping("/update/")
    public ResponseEntity<?> updateById(@RequestParam("id") int id,
                                        @RequestParam("name") String name,
                                        @RequestParam("projectCode") String projectCode) {
        ProjectDto dto = new ProjectDto();
        dto.setUpdatedTime(new Timestamp(new Date().getTime()));
        dto.setId(id);
        dto.setName(name);
        dto.setProjectCode(projectCode);
        return new ResponseEntity<>(projectService.updateOneById(dto), HttpStatus.OK);
    }

    @GetMapping("/create/")
    public ResponseEntity<?> createOne(@RequestParam("id") int id,
                                       @RequestParam("name") String name,
                                       @RequestParam("projectCode") String projectCode) {
        Project p = new Project();
        p.setCreatedTime(new Timestamp(new Date().getTime()));
        p.setName(name);
        p.setProjectCode(projectCode);
        return new ResponseEntity<>(projectService.createOne(p, id), HttpStatus.CREATED);
    }

    @GetMapping("/addResource")
    public ResponseEntity<?> addResource(@RequestParam("pid") int pid,
                                         @RequestParam("rid") int rid){
        return new ResponseEntity<>(projectResourceService.updateRelationship(pid, rid),HttpStatus.CREATED);
    }

}
