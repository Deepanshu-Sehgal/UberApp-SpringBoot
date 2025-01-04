package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.entities.Payment;
import com.datricle.project.uber.UberApp.entities.Ride;

public interface PaymentService {
    void processPayment(Payment payment);
    Payment createNewPayment(Ride ride);
}
