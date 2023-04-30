package com.knimbus.assignment.train.route.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.String;

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
public class IncludedAttributesDto {
  private String color;

  private String description;

  @JsonProperty(value = "direction_destinations")
  private String[] directionDestinations;

  @JsonProperty(value = "direction_names")
  private String[] directionNames;

  @JsonProperty(value = "fare_class")
  private String fareClass;

  @JsonProperty(value = "long_name")
  private String longName;

  @JsonProperty(value = "short_name")
  private String shortName;

  @JsonProperty(value = "sort_order")
  private int sortOrder;

  @JsonProperty(value = "text_color")
  private String textColor;

  private int type;

}
