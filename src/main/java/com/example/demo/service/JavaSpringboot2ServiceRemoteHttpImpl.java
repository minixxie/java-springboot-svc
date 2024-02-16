package com.example.demo.service;

import java.util.List;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * class JavaSpringboot2ServiceRemoteHttpImpl.
 */
@Service
@Slf4j
public class JavaSpringboot2ServiceRemoteHttpImpl implements JavaSpringboot2Service {
  private final String uriPrefix = "http://java-springboot2-svc.apps.svc:8080";

  public List<String> getRequestPaths() {
    String uri = this.uriPrefix + "/v1/request-paths";
    RestTemplate restTemplate = new RestTemplate();
    String upstreamResultJson = restTemplate.getForObject(uri, String.class);
    log.info("upstramResult: " + upstreamResultJson);

    List<String> appIdList = JsonPath.read(upstreamResultJson, "$.data.*");
    log.info("appIdList[0]: " + appIdList.get(0));
    return appIdList;
  }
}
