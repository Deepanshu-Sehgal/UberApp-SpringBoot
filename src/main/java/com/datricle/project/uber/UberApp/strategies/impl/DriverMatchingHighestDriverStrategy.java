package com.datricle.project.uber.UberApp.strategies.impl;

import com.datricle.project.uber.UberApp.dto.RideRequestDto;
import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.RideRequest;
import com.datricle.project.uber.UberApp.strategies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingHighestDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return List.of();
    }
}
