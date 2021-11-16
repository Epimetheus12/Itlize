package com.itlize.backend.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="project_sequence", sequenceName = "next_val")
    private int id;

    private String name;

    private String projectCode;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, targetEntity = User.class)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Set<ProjectResource> projectResourceSet = new HashSet<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<ProjectColumn> columnList;

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

    public User getUser( ) {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProjectResource> getProjectResourceSet( ) {
        return projectResourceSet;
    }

    public void setProjectResourceSet(ProjectResource projectResource) {
        this.projectResourceSet.add(projectResource);
    }

    public void setProjectResourceSet(Set<ProjectResource> projectResource) {
        this.projectResourceSet = projectResource;
    }

    public List<ProjectColumn> getColumnList( ) {
        return columnList;
    }

    public void setColumnList(List<ProjectColumn> columnList) {
        this.columnList = columnList;
    }

    public void setColumnList(ProjectColumn projectColumn) {
        this.columnList.add(projectColumn);
    }

    @Override
    public String toString( ) {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", user=" + user.getId() +
                '}';
    }
}
