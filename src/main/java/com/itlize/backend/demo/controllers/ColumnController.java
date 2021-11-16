package com.itlize.backend.demo.controllers;

import com.itlize.backend.demo.entities.*;
import com.itlize.backend.demo.services.ProjectColumnService;
import com.itlize.backend.demo.services.ProjectService;
import com.itlize.backend.demo.services.ResourceDetailsService;
import com.itlize.backend.demo.services.ResourceService;
import com.itlize.backend.demo.utils.dto.ProjectColumnDto;
import com.itlize.backend.demo.utils.dto.ResourceDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/column")
public class ColumnController {

    private final ProjectService projectService;
    private final ResourceService resourceService;
    private final ProjectColumnService projectColumnService;
    private final ResourceDetailsService resourceDetailsService;

    @Autowired
    public ColumnController(ProjectService projectService, ResourceService resourceService, ProjectColumnService projectColumnService, ResourceDetailsService resourceDetailsService) {
        this.projectService = projectService;
        this.resourceService = resourceService;
        this.projectColumnService = projectColumnService;
        this.resourceDetailsService = resourceDetailsService;
    }

    @GetMapping("/all/")
    public ResponseEntity<?> findAllColumn(@RequestParam("pid") int pid){


        Project project = projectService.findOneById(pid);
        if(project == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<ProjectColumn> rd = projectColumnService.findByProject(project);
        if(rd == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<String> columnNames = rd.stream().map(ProjectColumn::getColumnName).collect(Collectors.toList());
        return new ResponseEntity<>(columnNames, HttpStatus.OK);
    }

    @GetMapping("/add/")
    public ResponseEntity<?> addNewColumn(@RequestParam("pid") int pid,
                                          @RequestParam("columnName") String columnName,
                                          @RequestParam(value = "formula",required = false) String formula,
                                          @RequestParam(value = "type", required = false) String type){
        ProjectColumn pc = new ProjectColumn();
        Project project = projectService.findOneById(pid);
        if(project == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        pc.setColumnName(columnName);
        if(formula != null) pc.setFormula(formula);
        if(type != null) pc.setType(Type.valueOf(type));
        pc.setProject(project);
        ProjectColumn projectColumn = projectColumnService.addNewColumn(pc);

        return new ResponseEntity<>(projectColumn, HttpStatus.CREATED);
    }

    @GetMapping("/addValue/")
    public ResponseEntity<?> addNewValue(@RequestParam("cid") int cid,
                                         @RequestParam("rid") int rid,
                                         @RequestParam("value") String value){

        ProjectColumn pc = projectColumnService.findOneById(cid);
        Resource r = resourceService.findOneById(rid);
        if(pc == null || r == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        ResourceDetails rd = new ResourceDetails();
        rd.setColumnValue(value);
        rd.setProjectColumn(pc);
        rd.setResource(r);
        ResourceDetails resourceDetails = resourceDetailsService.create(rd);

        return new ResponseEntity<>(resourceDetails, HttpStatus.OK);
    }

    @GetMapping("/update/")
    public ResponseEntity<?> updateColumn(@RequestParam("id") int id,
                                          @RequestParam(value = "columnName", required = false) String columnName,
                                          @RequestParam(value = "formula",required = false) String formula,
                                          @RequestParam(value = "type", required = false) String type){
        ProjectColumnDto dto = new ProjectColumnDto();
        dto.setId(id);
        dto.setColumnName(columnName);
        dto.setFormula(formula);
        dto.setType(type);
        ProjectColumn projectColumn = projectColumnService.updateColumn(dto);
        return new ResponseEntity<>(projectColumn, HttpStatus.OK);
    }

    @GetMapping("/updateValue/")
    public ResponseEntity<?> updateColumnValue(@RequestParam("id") int id,
                                         @RequestParam("value") String value){


        ResourceDetailsDto dto = new ResourceDetailsDto();
        dto.setId(id);
        dto.setColumnValue(value);
        ResourceDetails resourceDetails = resourceDetailsService.update(dto);
        return new ResponseEntity<>(resourceDetails, HttpStatus.OK);
    }

    @GetMapping("/findValue/")
    public ResponseEntity<?> findColumnValue(@RequestParam("pid") int pid,
                                               @RequestParam("rid") int rid,
                                               @RequestParam("columnName") String columnName){


        Project project = projectService.findOneById(pid);
        Resource resource = resourceService.findOneById(rid);
        if(project == null || resource == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ResourceDetails rd = resourceDetailsService.findValue(resource, project, columnName);
        if(rd == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(rd.getColumnValue(), HttpStatus.OK);
    }

    @GetMapping("/delete/")
    public ResponseEntity<?> deleteColumn(@RequestParam("id") int id){
        ProjectColumn projectColumn = projectColumnService.findOneById(id);
        Boolean res = projectColumnService.deleteColumn(projectColumn);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
