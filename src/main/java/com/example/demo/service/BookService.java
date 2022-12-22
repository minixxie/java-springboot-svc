package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class BookService.
 */
@Service
@Slf4j
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

  /**
   * Get one book by bookId.
   *
   * @return {@link Book}
   */
  public Optional<Book> getBookById(Long bookId) {
    return this.bookRepository.findById(bookId);
  }

  /**
   * Create a book record.
   *
   * @return {@link Book}
   */
  public Book createBook(Book book) {
    return this.bookRepository.save(book);
  }
}
