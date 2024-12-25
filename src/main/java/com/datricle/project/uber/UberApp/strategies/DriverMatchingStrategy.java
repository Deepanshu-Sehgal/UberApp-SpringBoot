package com.datricle.project.uber.UberApp.strategies;

import com.datricle.project.uber.UberApp.dto.RideRequestDto;
import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
