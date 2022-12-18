package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {
  @GetMapping("/v1/books")
  public List getBooks() {
    return List.of(
      "Simon",
      "Garfunkel"
    );
  }
}
