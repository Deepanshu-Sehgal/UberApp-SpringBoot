package com.datricle.project.uber.UberApp.strategies.impl;

import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.RideRequest;
import com.datricle.project.uber.UberApp.repositories.DriverRepository;
import com.datricle.project.uber.UberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestStrategyImpl implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
