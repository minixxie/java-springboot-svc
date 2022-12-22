package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * class BookController, handles API endpoints about books.
 */
@RestController
@Slf4j
public class BookController {
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    log.info("BookController() constructor...");
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

  /**
   * Get one book.
   *
   * @return {@link Book}
   */
  @GetMapping("/v1/books/{bookId}")
  public Optional<Book> getBookById(@PathVariable Long bookId) {
    Optional<Book> book = this.bookService.getBookById(bookId);
    return book;
  }

  /**
   * Create a book.
   *
   * @return {@link Book}
   */
  @PostMapping("/v1/books")
  public Book createBook(@RequestBody Book book) {
    Book bk = this.bookService.createBook(book);
    return bk;
  }
}
