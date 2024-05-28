package com.lablpII.lablpII.services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lablpII.lablpII.dto.BookDto;
import com.lablpII.lablpII.entities.Book;
import com.lablpII.lablpII.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;
	
	@Transactional(readOnly = true)
    public BookDto findById(Long id) {
	    Optional<Book> result = repository.findById(id);
		Book entity = result.get();
		return new BookDto(entity);
	}

	@Transactional(readOnly = true)
    public Page<BookDto> findAll(Pageable pageable) {
	    Page<Book> result = repository.findAll(pageable);
		return result.map(x -> new BookDto(x));
	}

	@Transactional
	public BookDto insert(BookDto dto){
		Book entity = new Book();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());

		entity = repository.save(entity);

		return new BookDto(entity);
	}

	@Transactional
	public BookDto update(Long id, BookDto dto){
		Book entity = repository.getReferenceById(id);
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());

		entity = repository.save(entity);
		return new BookDto(entity);
	}

	@Transactional
	public void delete(Long id){
		repository.deleteById(id);
	}
}
