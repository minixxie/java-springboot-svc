package com.example.demo.support;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * For intercepting JSON response rendering, to make sure the JSON response has a standardized
 * format, and embed the result of the controller into the "data" field of the JSON response body.
 */
@RestControllerAdvice
@Slf4j
public class RestJsonWrapperAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class converterType) {
    return returnType.getDeclaringClass().getName().startsWith("com.example.demo.controller");
  }

  @Override
  public Object beforeBodyWrite(
      Object body,
      MethodParameter returnType,
      MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request,
      ServerHttpResponse response
  ) {
    SpanContext spanContext = Span.current().getSpanContext();
    response.getHeaders().add("traceparent",
        "00-" + spanContext.getTraceId() + "-"
        + spanContext.getSpanId() + "-" + spanContext.getTraceFlags());

    response.getHeaders().add("X-Request-ID", request.getHeaders().getFirst("X-Request-ID"));

    if (body instanceof ResponseBody) {
      return body;
    } else if (body instanceof Optional) {
      Optional op = (Optional) body;
      if (!op.isPresent()) {
        response.setStatusCode(HttpStatusCode.valueOf(404));
        return new ResponseBody();
      }
    }

    response.setStatusCode(HttpStatusCode.valueOf(200));
    return new ResponseBody(body);
  }
}
