package com.example.demo.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * class JavaSpringboot2Service.
 */
@Service
public interface JavaSpringboot2Service {
  public List<String> getRequestPaths();
}
