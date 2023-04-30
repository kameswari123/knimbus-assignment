package com.knimbus.assignment.train.route.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TrainPredictionsDataDto {
  private List<TrainAttributeRouteDataDto> data;
  private List<IncludedDataDto> included;
  @JsonProperty(value = "jsonapi")
  private JsonApiDto jsonApi;

}
