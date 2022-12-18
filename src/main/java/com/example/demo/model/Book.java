package com.example.demo.model;

/**
 * class Book, to represent a book object.
 */
public class Book {
  private Long id;
  private String isbn;
  private String title;

  /**
   * Constructor for initializing all attributes.
   */
  public Book(Long id, String isbn, String title) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
  }

  public Long getId() {
    return this.id;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public String getTitle() {
    return this.title;
  }
}
