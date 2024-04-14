package com.cadmus.endpoint;

import com.cadmus.model.Book;
import com.cadmus.service.BookService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {
    
    private static final String NAMESPACE_URI = "http://www.webservicesoap.org/camadus";
    
    private BookService bookService;
    
    public BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookByIdRequest")
    @ResponsePayload
    //JAXBElement<GetBookByIdResponse>
    public Book getBookById( @RequestPayload GetBookByIdRequest request) {
        return bookService.getBookById((long)request.getId());
    }
}