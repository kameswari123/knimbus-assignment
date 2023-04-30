package com.knimbus.assignment.train.route.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;

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
public class TrainAttributeRouteDataDto {
  private Attributes attributes;

  private String id;

  private Relationships relationships;

  private String type;
}
