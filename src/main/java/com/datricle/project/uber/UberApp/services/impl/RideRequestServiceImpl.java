package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.entities.RideRequest;
import com.datricle.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.datricle.project.uber.UberApp.repositories.RideRequestRepository;
import com.datricle.project.uber.UberApp.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {
    private final RideRequestRepository rideRequestRepository;
    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId).orElseThrow(
                ()-> new ResourceNotFoundException("Ride Request now found with id: " + rideRequestId)
        );
    }
}
