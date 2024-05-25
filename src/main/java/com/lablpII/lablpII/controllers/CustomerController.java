package com.lablpII.lablpII.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lablpII.lablpII.dto.CustomerDto;
import com.lablpII.lablpII.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDto>> findAll(Pageable pageable){
        return ResponseEntity
                .ok(service.findAll(pageable));
    }
}
