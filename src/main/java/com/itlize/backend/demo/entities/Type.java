package com.itlize.backend.demo.entities;

public enum Type {
    number("number"),
    text("text"),
    formula("formula");

    private final String type;
    private Type(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}
