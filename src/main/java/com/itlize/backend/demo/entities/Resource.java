package com.itlize.backend.demo.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="resource_sequence", sequenceName = "next_val")
    private int id;
    private String name;
    private String resourceCode;

    @CreationTimestamp
    private Timestamp createdTime;
    @UpdateTimestamp
    private Timestamp updatedTime;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "resource")
    private Set<ProjectResource> projectResourceSet = new HashSet<>();

//    @OneToMany(mappedBy = "resource", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @MapKeyColumn(name = "columnName")
//    private Map<String, ProjectColumn> columnMap;

    @OneToMany(mappedBy = "resource", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ResourceDetails> resourceDetailsList;

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

    public Set<ProjectResource> getProjectResourceSet( ) {
        return projectResourceSet;
    }

    public void setProjectResourceSet(ProjectResource projectResource) {
        this.projectResourceSet.add(projectResource);
    }

    public void setProjectResourceSet(Set<ProjectResource> projectResourceSet) {
        this.projectResourceSet= projectResourceSet;
    }

    public List<ResourceDetails> getResourceDetailsList( ) {
        return resourceDetailsList;
    }

    public void setResourceDetailsList(List<ResourceDetails> resourceDetailsList) {
        this.resourceDetailsList = resourceDetailsList;
    }

    public void setResourceDetailsList(ResourceDetails resourceDetails) {
        this.resourceDetailsList.add(resourceDetails);
    }


    //    public Map<String, ProjectColumn> getColumnMap( ) {
//        return columnMap;
//    }
//
//    public void setColumnMap(Map<String, ProjectColumn> columnMap) {
//        this.columnMap = columnMap;
//    }
//
//    public void setColumnMap(ProjectColumn pc) {
//        this.columnMap.put(pc.getColumnName(), pc);
//    }



    @Override
    public String toString( ) {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceCode='" + resourceCode + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", resourceDetailsList=" + resourceDetailsList +
                '}';
    }
}
// test change