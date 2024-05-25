package com.lablpII.lablpII.dto;

import com.lablpII.lablpII.entities.Book;

import lombok.Getter;

@Getter
public class BookDto {
    private Long id;
    private String name;
    private Double price;

    public BookDto(){}

    public BookDto(Long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public BookDto(Book entity){
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
    }
}
