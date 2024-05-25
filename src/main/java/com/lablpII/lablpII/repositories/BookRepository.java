package com.lablpII.lablpII.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lablpII.lablpII.entities.Book;


public interface BookRepository extends JpaRepository<Book, Long>{
    
}
