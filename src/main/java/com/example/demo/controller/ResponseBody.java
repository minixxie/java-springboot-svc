package com.example.demo.controller;

/**
 * Represents a HTTP JSON response body.
 */
public class ResponseBody {
  private Object data;

  public ResponseBody() {
  }

  public ResponseBody(Object data) {
    this.data = data;
  }

  public Object getData() {
    return this.data;
  }
}
