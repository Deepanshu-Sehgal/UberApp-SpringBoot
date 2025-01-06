package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.dto.DriverDto;
import com.datricle.project.uber.UberApp.dto.RideDto;
import com.datricle.project.uber.UberApp.dto.RideRequestDto;
import com.datricle.project.uber.UberApp.dto.RiderDto;
import com.datricle.project.uber.UberApp.entities.*;
import com.datricle.project.uber.UberApp.entities.enums.RideRequestStatus;
import com.datricle.project.uber.UberApp.entities.enums.RideStatus;
import com.datricle.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.datricle.project.uber.UberApp.repositories.RideRequestRepository;
import com.datricle.project.uber.UberApp.repositories.RiderRepository;
import com.datricle.project.uber.UberApp.services.DriverService;
import com.datricle.project.uber.UberApp.services.RatingService;
import com.datricle.project.uber.UberApp.services.RideService;
import com.datricle.project.uber.UberApp.services.RiderService;
import com.datricle.project.uber.UberApp.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager strategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideService rideService;
    private final DriverService driverService;
    private final RatingService ratingService;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = strategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = strategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);
        //TODO: send notifications to all the drivers about this ride request
        return modelMapper.map(savedRideRequest, RideRequestDto.class);

    }

    @Override
    public RideDto cancelRide(Long rideId) {
        Rider rider = getCurrentRider();
        Ride ride = rideService.getRideById(rideId);

        if (!rider.equals(ride.getRider())) {
            throw new RuntimeException("Rider does not own this ride with id:" + rideId);
        }

        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride cannot be cancelled, invalid status: " + ride.getRideStatus());
        }

        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);
        driverService.updateDriverAvailability(ride.getDriver(), true);
        return modelMapper.map(savedRide, RideDto.class);
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        Ride ride = rideService.getRideById(rideId);
        Rider rider = getCurrentRider();

        if (!rider.equals(ride.getRider())) {
            throw new RuntimeException("Rider is not the owner of this Ride");
        }

        if (!ride.getRideStatus().equals(RideStatus.ENDED)) {
            throw new RuntimeException("Ride status is not ENDED hence cannot start rating, status: " + ride.getRideStatus());
        }

        return ratingService.rateDriver(ride, rating);
    }

    @Override
    public RiderDto getMyProfile() {
        Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDto.class);
    }

    @Override
    public Page<RideDto> getAllMyRider(PageRequest pageRequest) {
        Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider, pageRequest).map(
                ride -> modelMapper.map(ride, RideDto.class)
        );
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Rider not found with id: " + 1));
    }
}
