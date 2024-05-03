package com.lablpII.lablpII.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lablpII.lablpII.entities.Book;
import com.lablpII.lablpII.projections.BookMinProjection;
import com.lablpII.lablpII.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
	
    public Book findById(Long id) {
	    Optional<Book> result = bookRepository.findById(id);
		Book entity = result.get();
		return entity;
	}

	public List<BookMinProjection> showCatalog(){
		return bookRepository.search();
	}
}
