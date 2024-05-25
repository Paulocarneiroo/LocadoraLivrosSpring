package com.lablpII.lablpII.controllers;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<BookDto> insert(@RequestBody BookDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
