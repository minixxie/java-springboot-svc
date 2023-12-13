package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.ArrayList;
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
 * class MainController, handles "main" API endpoints.
 */
@RestController
@Slf4j
public class MainController {

  @Autowired
  public MainController() {
    log.info("MainController() constructor...");
  }

  /**
   * Get request paths.
   *
   * @return {@link List} of {@link String}
   */
  @GetMapping("/v1/request-paths")
  public List<String> getRequestPaths() {
    ArrayList<String> result = new ArrayList();
    result.add(System.getenv("appID"));
    return result;
  }
}
