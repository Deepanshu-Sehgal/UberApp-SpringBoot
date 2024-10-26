package com.datricle.project.uber.UberApp.strategies.impl;

import com.datricle.project.uber.UberApp.dto.RideRequestDto;
import com.datricle.project.uber.UberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareCalculationStrategyImpl implements RideFareCalculationStrategy
{
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
