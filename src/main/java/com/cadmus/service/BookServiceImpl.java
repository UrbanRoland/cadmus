package com.cadmus.service;

import com.cadmus.model.Book;
import com.cadmus.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    
    private BookRepository bookRepository;
    
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public BookServiceImpl() {
    }
    
    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}