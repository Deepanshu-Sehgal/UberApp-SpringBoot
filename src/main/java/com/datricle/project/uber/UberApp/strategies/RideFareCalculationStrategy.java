package com.datricle.project.uber.UberApp.strategies;

import com.datricle.project.uber.UberApp.dto.RideRequestDto;
import com.datricle.project.uber.UberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDto rideRequestDto);

}
