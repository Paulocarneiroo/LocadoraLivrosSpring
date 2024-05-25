package com.lablpII.lablpII.dto;

import com.lablpII.lablpII.entities.Customer;

import lombok.Getter;

@Getter
public class CustomerDto {
    private Long id;
    private String name;
    private String email;

    public CustomerDto(){}

    public CustomerDto(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerDto(Customer entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }
}
