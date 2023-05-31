package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Employee {
    private final String id;
    private final String name;
    private final String title;
    private final String department;

    public Employee(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("title") String title, @JsonProperty("department") String department) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.department = department;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
         return this.name;
    }
    public String getTitle() {
        return this.title;
    }
    public String getDepartment() {
        return this.department;
    }
}
