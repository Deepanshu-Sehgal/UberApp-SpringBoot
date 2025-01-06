package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.Ride;
import com.datricle.project.uber.UberApp.entities.Rider;

public interface RatingService {

    void rateDriver(Ride ride, Driver driver, Integer rating);

    void rateRider(Ride ride, Rider rider, Integer rating);

}
