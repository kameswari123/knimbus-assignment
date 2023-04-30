package com.knimbus.assignment.train.route.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.knimbus.assignment.train.route.dto.TrainPredictionsDataDto;
import com.knimbus.assignment.util.RestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Component
public class TrainRouteDataUtil {
  ObjectMapper objectMapper = JsonMapper.builder()
      .addModule(new JavaTimeModule())
      .build();
  @Autowired
  private RestUtils restUtils;

  public Optional<TrainPredictionsDataDto> getTrainRouteData() throws IOException {
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    String url
        = "https://api-v3.mbta.com/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route";
    String response = restUtils.get(url);
    if (!StringUtils.isEmpty(response)) {
      TrainPredictionsDataDto trainPredictionsDataDto = objectMapper.readValue(response, TrainPredictionsDataDto.class);
      return Optional.ofNullable(trainPredictionsDataDto);
    }
    return Optional.empty();
  }
}
