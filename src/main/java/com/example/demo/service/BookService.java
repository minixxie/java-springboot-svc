package com.example.demo.service;

import com.example.demo.mapper.BookMapper;
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

  private final BookMapper bookMapper;
  private final BookRepository bookRepository;
  private final boolean useMyBatis;

  /**
   * Constructor with dependencies injection.
   */
  @Autowired
  public BookService(BookMapper bookMapper, BookRepository bookRepository) {
    this.useMyBatis = true;
    this.bookMapper = bookMapper;
    this.bookRepository = bookRepository;
  }

  /**
   * Get all books.
   *
   * @return {@link List} of {@link Book}
   */
  public List<Book> getBooks() {
    if (useMyBatis) {
      log.debug("Using MyBatis...");
      return this.bookMapper.findAll();
    } else {
      return this.bookRepository.findAll();
    }
  }

  /**
   * Get one book by bookId.
   *
   * @return {@link Book}
   */
  public Optional<Book> getBookById(Long bookId) {
    if (useMyBatis) {
      log.debug("Using MyBatis...");
      return this.bookMapper.findById(bookId);
    } else {
      return this.bookRepository.findById(bookId);
    }
  }

  /**
   * Create a book record.
   *
   * @return {@link Book}
   */
  public Book createBook(Book book) {
    if (useMyBatis) {
      log.debug("Using MyBatis...");
      this.bookMapper.insert(book);
      return book;
    } else {
      return this.bookRepository.save(book);
    }
  }
}
