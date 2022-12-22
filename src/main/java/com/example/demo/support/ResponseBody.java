package com.example.demo.support;

import java.util.Optional;

/**
 * Represents a HTTP JSON response body.
 */
public class ResponseBody {
  private Object data;

  /**
   * To represent empty "data" object inside the JSON response.
   */
  public static class Empty {
  }

  /**
   * Default constructor.
   */
  public ResponseBody() {
    this.data = new Empty();
  }

  /**
   * Construct with any type of object, to be returned as "data" object inside the JSON response.
   */
  public ResponseBody(Object data) {
    if (data instanceof Optional) {
      Optional op = (Optional) data;
      if (!op.isPresent()) {
        this.data = new Empty();
      } else {
        this.data = data;
      }
    } else {
      this.data = data;
    }
  }

  public Object getData() {
    return this.data;
  }
}
