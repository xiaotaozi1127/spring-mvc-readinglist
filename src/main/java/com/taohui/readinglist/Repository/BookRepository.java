package com.taohui.readinglist.Repository;

import com.taohui.readinglist.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
