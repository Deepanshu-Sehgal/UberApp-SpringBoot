package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.dto.DriverDto;
import com.datricle.project.uber.UberApp.dto.RideDto;
import com.datricle.project.uber.UberApp.dto.RiderDto;
import com.datricle.project.uber.UberApp.entities.RideRequest;
import com.datricle.project.uber.UberApp.entities.enums.RideRequestStatus;
import com.datricle.project.uber.UberApp.services.DriverService;
import com.datricle.project.uber.UberApp.services.RideRequestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideRequestService rideRequestService;

    @Override
    public RideDto acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);


        if (!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("RideRequest Can't be Accepted, status is " + rideRequest.getRideRequestStatus());
        }

        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);


        return null;
    }

    @Override
    public RideDto requestRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRider() {
        return List.of();
    }
}
