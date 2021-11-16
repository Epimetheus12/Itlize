package com.itlize.backend.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="project_resource_sequence", sequenceName = "next_val")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, targetEntity = Project.class)
    @JsonIgnore
    private Project project;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, targetEntity = Resource.class)
    @JsonIgnore
    private Resource resource;

    public int getId( ) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject( ) {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resource getResource( ) {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString( ) {
        return "ProjectResource{" +
                "id=" + id +
                ", project=" + project.getId() +
                ", resource=" + resource.getId() +
                '}';
    }
}
