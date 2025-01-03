package com.datricle.project.uber.UberApp.dto;

import com.datricle.project.uber.UberApp.entities.enums.PaymentMethod;
import com.datricle.project.uber.UberApp.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
public class RideDto {
    private Long id;
    private PointDto pickupLocation;
    private PointDto dropOffLocation;

    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;


    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private LocalDateTime statedAt;
    private LocalDateTime endedAt;
}
