package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class BookService.
 */
@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  /**
   * Get all books.
   *
   * @return {@link List} of {@link Book}
   */
  public List<Book> getBooks() {
    return this.bookRepository.findAll();
  }
}
