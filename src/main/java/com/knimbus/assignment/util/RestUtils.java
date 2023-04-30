package com.knimbus.assignment.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtils {
  public String get(String url) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response
        = restTemplate.getForEntity(url, String.class);
    return response.getBody();
  }
}
