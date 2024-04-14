package com.cadmus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    
    Long getId() {
        return id;
    }
    
    void setId(Long id) {
        this.id = id;
    }
    
    String getTitle() {
        return title;
    }
    
    void setTitle(String title) {
        this.title = title;
    }
    
    String getAuthor() {
        return author;
    }
    
    void setAuthor(String author) {
        this.author = author;
    }
    
    String getIsbn() {
        return isbn;
    }
    
    void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}