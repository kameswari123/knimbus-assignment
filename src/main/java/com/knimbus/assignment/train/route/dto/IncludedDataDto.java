package com.knimbus.assignment.train.route.dto;

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
public class IncludedDataDto {
  private IncludedAttributesDto attributes;

  private String id;

  private Links links;

  private IncludedRelationshipsDto relationships;

  private String type;
}
