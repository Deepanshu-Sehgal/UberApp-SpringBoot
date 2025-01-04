package com.datricle.project.uber.UberApp.strategies;

import com.datricle.project.uber.UberApp.entities.Payment;

public interface PaymentStrategy {
    void processPayment(Payment payment);
}
