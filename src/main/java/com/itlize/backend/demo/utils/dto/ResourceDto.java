package com.itlize.backend.demo.utils.dto;

import java.sql.Timestamp;

public class ResourceDto {
    private int id;
    private String name;
    private String resourceCode;

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

}
