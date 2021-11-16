package com.itlize.backend.demo.utils.dto;

import com.itlize.backend.demo.entities.Type;


public class ProjectColumnDto {
    private int id;

    private String columnName;

    private String type;

    private String formula;

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

    public String getType( ) {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormula( ) {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
