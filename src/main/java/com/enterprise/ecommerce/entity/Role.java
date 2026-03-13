package com.enterprise.ecommerce.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "roles")

public class Role {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime createdTime;

    public Role() {}

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdTime = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String Description(){
        return description;
    }

    public LocalDateTime getCreatedTime(){
        return createdTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
