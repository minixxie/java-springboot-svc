package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * class BookService.
 */
@Service
public class BookService {
  /**
   * Get all books.
   *
   * @return {@link List} of {@link Book}
   */
  public List<Book> getBooks() {
    return List.of(
      new Book(
        Long.valueOf(1),
        "978-1400079988",
        "War and Peace"
      )
    );
  }
}
