package com.itlize.backend.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="resource_sequence", sequenceName = "next_val")
    private int id;
    private String name;
    private String resourceCode;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resource")
    private List<ProjectResource> projectResourceList = new ArrayList<>();

    public int getId( ) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceCode( ) {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public Timestamp getCreatedTime( ) {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime( ) {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<ProjectResource> getProjectResourceList( ) {
        return projectResourceList;
    }

    public void setProjectResourceList(ProjectResource projectResource) {
        this.projectResourceList.add(projectResource);
    }
}
