package com.lablpII.lablpII.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lablpII.lablpII.entities.Book;
import com.lablpII.lablpII.projections.BookMinProjection;

public interface BookRepository extends JpaRepository<Book, Long>{
    
    @Query(nativeQuery = true, value = "SELECT * FROM tb_books")
    List<BookMinProjection> search();
}
