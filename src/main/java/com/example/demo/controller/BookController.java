package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Get all books.
   *
   * @return {@link List} of {@link Book} in {@link ResponseBody}
   */
  @GetMapping("/v1/books")
  public ResponseEntity<ResponseBody> getBooks() {
    return new ResponseEntity<ResponseBody>(
        new ResponseBody(this.bookService.getBooks()), HttpStatusCode.valueOf(200));
  }

  /**
   * Get one book.
   *
   * @return {@link Book} in {@link ResponseBody}
   */
  @GetMapping("/v1/books/{bookId}")
  public ResponseEntity<ResponseBody> getBookById(@PathVariable Long bookId) {
    Optional<Book> book = this.bookService.getBookById(bookId);
    return new ResponseEntity<ResponseBody>(
        new ResponseBody(book), HttpStatusCode.valueOf(book.isPresent() ? 200 : 404));
  }

  /**
   * Create a book.
   *
   * @return {@link Book} in {@link ResponseBody}
   */
  @PostMapping("/v1/books")
  public ResponseEntity<ResponseBody> createBook(@RequestBody Book book) {
    Book bk = this.bookService.createBook(book);
    return new ResponseEntity<ResponseBody>(new ResponseBody(bk), HttpStatusCode.valueOf(200));
  }
}
