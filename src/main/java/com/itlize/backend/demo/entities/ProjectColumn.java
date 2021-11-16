package com.itlize.backend.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.security.PrivateKey;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProjectColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="project_column_sequence", sequenceName = "next_val")
    private int id;

    private String columnName;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String formula;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH}, targetEntity = Project.class)
    @JsonIgnore
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "projectColumn")
    private List<ResourceDetails> resourceDetailsList = new ArrayList<>();


    public int getId( ) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColumnName( ) {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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

    public Project getProject( ) {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Type getType( ) {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFormula( ) {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<ResourceDetails> getResourceDetailsList( ) {
        return resourceDetailsList;
    }

    public void setResourceDetailsList(ResourceDetails resourceDetails) {
        this.resourceDetailsList.add(resourceDetails);
    }

    public void setResourceDetailsList(List<ResourceDetails> resourceDetailsList) {
        this.resourceDetailsList = resourceDetailsList;
    }

    @Override
    public String toString( ) {
        return "ProjectColumn{" +
                "id=" + id +
                ", columnName='" + columnName + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
