package com.lablpII.lablpII.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lablpII.lablpII.dto.BookDto;
import com.lablpII.lablpII.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    
    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<BookDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
