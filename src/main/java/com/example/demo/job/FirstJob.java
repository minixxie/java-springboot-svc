package com.example.demo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * FirstJob.
 */
@Slf4j
@Component
public class FirstJob {

  /**
   * firstJob.
   */
  @XxlJob(value = "firstJob", init = "init", destroy = "destroy")
  public ReturnT<String> execute(String param) {
    log.info("XXL-JOB, firstJob. param: {}", param);

    return ReturnT.SUCCESS;
  }

  public void init() {
    log.info("init");
  }

  public void destroy() {
    log.info("destroy");
  }
}
