package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.dto.DriverDto;
import com.datricle.project.uber.UberApp.dto.RideDto;
import com.datricle.project.uber.UberApp.dto.RiderDto;
import com.datricle.project.uber.UberApp.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);

    RideDto requestRide(Long rideId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRider(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver, boolean available);


}
