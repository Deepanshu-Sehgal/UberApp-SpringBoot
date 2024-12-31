package com.datricle.project.uber.UberApp.strategies;

import com.datricle.project.uber.UberApp.strategies.impl.DriverMatchingHighestRatingDriverStrategy;
import com.datricle.project.uber.UberApp.strategies.impl.DriverMatchingNearestStrategyImpl;
import com.datricle.project.uber.UberApp.strategies.impl.RideFareDefaultFareCalculationStrategyImpl;
import com.datricle.project.uber.UberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
    private final DriverMatchingHighestRatingDriverStrategy highestRatingDriverStrategy;
    private final DriverMatchingNearestStrategyImpl nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategyImpl rideFareDefaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if (riderRating >= 4.8) return highestRatingDriverStrategy;
        else return nearestDriverStrategy;
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy() {
        //6 pm to 9 pm
        LocalTime surgeStart = LocalTime.of(18, 0);
        LocalTime surgeEnd = LocalTime.of(21, 0);
        LocalTime currTime = LocalTime.now();
        boolean isSurgeTime = currTime.isAfter(surgeStart) && currTime.isBefore(surgeEnd);
        if (isSurgeTime) return rideFareSurgePricingFareCalculationStrategy;
        else return rideFareDefaultFareCalculationStrategy;
    }

}
