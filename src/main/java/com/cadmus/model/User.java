package com.cadmus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String contact;
    
    Long getId() {
        return id;
    }
    
    void setId(Long id) {
        this.id = id;
    }
    
    String getName() {
        return name;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    String getEmail() {
        return email;
    }
    
    void setEmail(String email) {
        this.email = email;
    }
    
    String getContact() {
        return contact;
    }
    
    void setContact(String contact) {
        this.contact = contact;
    }
}