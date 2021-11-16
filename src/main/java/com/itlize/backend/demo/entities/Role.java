package com.itlize.backend.demo.entities;


public enum Role {
    root("root"),
    admin("admin"),
    user("user");

    private final String name;
    private Role(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
