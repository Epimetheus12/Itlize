package com.itlize.backend.demo.entities;

import javax.persistence.*;

@Entity
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="project_resource_sequence", sequenceName = "next_val")
    private int id;

    @ManyToOne(targetEntity = Project.class, fetch = FetchType.LAZY)
    private Project project;

    @ManyToOne(targetEntity = Resource.class, fetch = FetchType.LAZY)
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
}
