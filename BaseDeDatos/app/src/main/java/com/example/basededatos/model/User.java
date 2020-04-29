package com.example.basededatos.model;

public class User {


    private Integer id;
    private String name;
    private String cell;

    public void User(Integer id, String name, String cell) {
        this.id = id;
        this.name = name;
        this.cell = cell;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
}
