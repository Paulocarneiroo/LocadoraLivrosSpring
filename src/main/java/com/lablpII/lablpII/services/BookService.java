package com.lablpII.lablpII.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.lablpII.lablpII.repositories.BookRepository;

public class BookService {
    
    @Autowired
    private BookRepository repository;

    /*
     *  public BookMinDto findById(Long id) {
		Optional<Book> result = repository.findById(id);
		Book entity = result.get();
		return new BookMinDto(entity);
	}
     * 
     */ 
}
