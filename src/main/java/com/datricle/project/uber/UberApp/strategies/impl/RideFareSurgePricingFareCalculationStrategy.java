package com.datricle.project.uber.UberApp.strategies.impl;

import com.datricle.project.uber.UberApp.entities.RideRequest;
import com.datricle.project.uber.UberApp.services.DistanceService;
import com.datricle.project.uber.UberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    private static final double SURGE_FACTOR = 2;
    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLIER * SURGE_FACTOR;
    }
}
