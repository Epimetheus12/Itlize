package com.itlize.backend.demo.entities;

import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="project_sequence", sequenceName = "next_val")
    private int id;

    private String name;

    private String projectCode;

    private Date createdTime;

    private Date updatedTime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, targetEntity = User.class)
    private User user;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public String getProjectCode( ) {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getCreatedTime( ) {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime( ) {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public User getUser( ) {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProjectResource> getProjectResourceList( ) {
        return projectResourceList;
    }

    public void setProjectResourceList(ProjectResource projectResource) {
        this.projectResourceList.add(projectResource);
    }
}
