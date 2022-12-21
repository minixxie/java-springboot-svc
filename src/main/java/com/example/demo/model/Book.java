package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * class Book, to represent a book object.
 */
@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "title")
  private String title;

  /**
   * Default constructor (required by Hibernate).
   */
  public Book() {
  }

  /**
   * Constructor for initializing all attributes.
   */
  public Book(Long id, String isbn, String title) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
  }

  public void setId(Long id) {
    this.id = id;
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
