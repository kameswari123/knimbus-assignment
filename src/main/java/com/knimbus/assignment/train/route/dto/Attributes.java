package com.knimbus.assignment.train.route.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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
public class Attributes {
  @JsonProperty(value = "arrival_time")
  @JsonFormat(pattern = "uuuu-MM-dd'T'HH:m:ssxxx")
  private OffsetDateTime arrivalTime;

  @JsonProperty(value = "departure_time")
  @JsonFormat(pattern = "uuuu-MM-dd'T'HH:m:ssxxx")
  private OffsetDateTime departureTime;

  @JsonProperty(value = "direction_id")
  private int directionId;

  @JsonProperty(value = "schedule_relationship")
  private String scheduleRelationship;

  private String status;

  @JsonProperty(value = "stop_sequence")
  private int stopSequence;
}
