package com.softserve.edu.entity;


public class Entity {
    private int id; // must be unique
    private String name;
    private static int idCounter = 0;


    public Entity(String name) {
        id = ++idCounter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
