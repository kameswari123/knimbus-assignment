package com.knimbus.assignment.train.route.details;

import com.knimbus.assignment.train.route.dto.IncludedDataDto;
import com.knimbus.assignment.train.route.dto.TrainAttributeRouteDataDto;
import com.knimbus.assignment.train.route.dto.TrainPredictionsDataDto;
import com.knimbus.assignment.train.route.util.TrainRouteDataUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainRouteDetailsComponent {
  @Autowired
  private TrainRouteDataUtil trainRouteDataUtil;

  public void getPredictions() throws IOException {
    Optional<TrainPredictionsDataDto> trainRouteData = trainRouteDataUtil.getTrainRouteData();
    if (trainRouteData.isPresent()) {
      List<TrainAttributeRouteDataDto> attributeRouteDataDtos = trainRouteData.get().getData();
      List<IncludedDataDto> included = trainRouteData.get().getIncluded();
      List<TrainAttributeRouteDataDto> nextDepartureTrains =
          getNextDepartureTrains(attributeRouteDataDtos);
      nextDepartureTrains.stream().collect(Collectors.groupingBy(
              trainAttributeRouteDataDto -> trainAttributeRouteDataDto.getRelationships().getRoute().getData().getId()))
          .entrySet().stream().forEach(map -> {
            System.out.println("----" + map.getKey() + "----");
            System.out.println(OffsetDateTime.now());
            getDestination(included, map);
          });
    }
  }

  private void getDestination(List<IncludedDataDto> included,
      Map.Entry<String, List<TrainAttributeRouteDataDto>> trainAttributeslist) {
    trainAttributeslist.getValue().stream().forEach(trainRouteDto -> {
      OffsetDateTime departureTime = trainRouteDto.getAttributes().getDepartureTime();
      Duration between = Duration.between(OffsetDateTime.now(), departureTime);
      included.stream().filter(includedDataDto ->
              includedDataDto.getId().equalsIgnoreCase(trainAttributeslist.getKey()))
          .forEach(includedDataDto -> {
            String[] directionDestinations = includedDataDto.getAttributes().getDirectionDestinations();
            String destinations = String.join("/", directionDestinations);
            System.out.println(destinations + ":Departing in " + between.toMinutes() + "minutes.");
          });
    });
  }

  private List<TrainAttributeRouteDataDto> getNextDepartureTrains(
      List<TrainAttributeRouteDataDto> attributeRouteDataDtos) {
    return attributeRouteDataDtos.stream().filter(trainAttributeRouteDataDto ->
            trainAttributeRouteDataDto.getAttributes().getDepartureTime().isAfter(OffsetDateTime.now()))
        .limit(10)
        .collect(Collectors.toList());
  }
}
