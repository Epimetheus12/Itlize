package com.itlize.backend.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ResourceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="resource_details_sequence", sequenceName = "next_val")
    private int id;

    private String columnValue;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = ProjectColumn.class)
    @JsonIgnore
    private ProjectColumn projectColumn;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = Resource.class)
    @JsonIgnore
    private Resource resource;

    public int getId( ) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColumnValue( ) {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
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

    public ProjectColumn getProjectColumn( ) {
        return projectColumn;
    }

    public void setProjectColumn(ProjectColumn projectColumn) {
        this.projectColumn = projectColumn;
    }

    public Resource getResource( ) {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString( ) {
        return "ResourceDetails{" +
                "id=" + id +
                ", columnValue='" + columnValue + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", projectColumn=" + projectColumn.getId() +
                ", resource=" + resource.getId() +
                '}';
    }
}
