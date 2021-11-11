package com.itlize.backend.demo.utils.dto;

import java.util.Date;

public class ProjectDto {
    private int id;

    private String name;

    private String projectCode;

    private Date updatedTime;

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

    public Date getUpdatedTime( ) {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
