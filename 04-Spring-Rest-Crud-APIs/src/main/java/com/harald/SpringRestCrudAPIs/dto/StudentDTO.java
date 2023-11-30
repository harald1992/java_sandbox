package com.harald.SpringRestCrudAPIs.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDTO {
    public int id;
    public String name;
    public String email;

    // No-argument constructor
    public StudentDTO() {
        this.id = 0; // Default value for id
        this.name = "";
        this.email = "";
    }

    // Constructor with all arguments
    public StudentDTO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
