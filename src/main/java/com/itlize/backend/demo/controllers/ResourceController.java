package com.itlize.backend.demo.controllers;

import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.services.ProjectResourceService;
import com.itlize.backend.demo.services.ResourceService;
import com.itlize.backend.demo.utils.dto.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "/resource")
public class ResourceController {
    private final ResourceService resourceService;
    private final ProjectResourceService projectResourceService;

    @Autowired
    public ResourceController(ResourceService resourceService, ProjectResourceService projectResourceService) {
        this.resourceService = resourceService;
        this.projectResourceService = projectResourceService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> allResources() {
        return new ResponseEntity< >(resourceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> resourceById(@RequestParam("id") int id) {
        return new ResponseEntity< >(resourceService.findOneById(id), HttpStatus.OK);
    }

    @GetMapping("/project/")
    public ResponseEntity<?> resourceByProject(@RequestParam("id") int id) {
        return new ResponseEntity< >(projectResourceService.findResourceByProject(id), HttpStatus.OK);
    }

    @GetMapping("/delete/")
    public ResponseEntity<?> deleteById(@RequestParam("id") int id){
        Resource resource = resourceService.findOneById(id);
        return new ResponseEntity< >(resourceService.deleteOne(resource), HttpStatus.OK);
    }

    @GetMapping("/update/")
    public ResponseEntity<?> updateById(@RequestParam("id") int id,
                                        @RequestParam(value = "name",required = false) String name,
                                        @RequestParam(value = "resourceCode",required = false) String resourceCode) {
        ResourceDto dto = new ResourceDto();
        dto.setId(id);
        dto.setName(name);
        dto.setResourceCode(resourceCode);
        return new ResponseEntity<>(resourceService.updateOneById(dto), HttpStatus.OK);
    }

    @GetMapping("/create/")
    public ResponseEntity<?> createOne(@RequestParam("name") String name,
                                       @RequestParam("resourceCode") String resourceCode) {
        Resource r = new Resource();
        r.setName(name);
        r.setResourceCode(resourceCode);
        return new ResponseEntity<>(resourceService.createOne(r), HttpStatus.CREATED);
    }

    @GetMapping("/addProject/")
    public ResponseEntity<?> addProject(@RequestParam("pid") int pid,
                                         @RequestParam("rid") int rid){
        return new ResponseEntity<>(projectResourceService.updateRelationship(pid, rid),HttpStatus.CREATED);
    }


}
