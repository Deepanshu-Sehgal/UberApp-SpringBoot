package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.Rating;
import com.datricle.project.uber.UberApp.entities.Ride;
import com.datricle.project.uber.UberApp.entities.Rider;
import com.datricle.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.datricle.project.uber.UberApp.repositories.DriverRepository;
import com.datricle.project.uber.UberApp.repositories.RatingRepository;
import com.datricle.project.uber.UberApp.repositories.RiderRepository;
import com.datricle.project.uber.UberApp.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;

    @Override
    public void rateDriver(Ride ride, Driver driver, Integer rating) {
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found for ride with id" + ride.getId()));
        ratingObj.setDriverRating(rating);
        ratingRepository.save(ratingObj);
        Double newRating = ratingRepository.findByDriver(driver).stream().mapToDouble(Rating::getDriverRating).average().orElse(0.0);
        driver.setRating(newRating);
        driverRepository.save(driver);
    }

    @Override
    public void rateRider(Ride ride, Rider rider, Integer rating) {
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found for ride with id" + ride.getId()));
        ratingObj.setRiderRating(rating);

        ratingRepository.save(ratingObj);
        Double newRating = ratingRepository.findByRider(rider).stream().mapToDouble(Rating::getRiderRating).average().orElse(0.0);
        rider.setRating(newRating);
        riderRepository.save(rider);
    }
}
