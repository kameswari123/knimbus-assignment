package com.knimbus.assignment.train.route.controller;

import com.knimbus.assignment.train.route.details.TrainRouteDetailsComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TrainRouteController {

  @Autowired
  private TrainRouteDetailsComponent trainRouteDetailsComponent;

  @GetMapping(path = "/train-route")
  public void getTrainRoutDetails() throws IOException {
    trainRouteDetailsComponent.getPredictions();
  }
}
