package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to manage book records.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

