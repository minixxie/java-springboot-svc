package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class BookController, handles API endpoints about books.
 */
@RestController
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Get all books.
   *
   * @return {@link List} of {@link Book}
   */
  @GetMapping("/v1/books")
  public List<Book> getBooks() {
    return this.bookService.getBooks();
  }
}
