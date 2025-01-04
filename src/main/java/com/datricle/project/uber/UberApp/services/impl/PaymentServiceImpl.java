package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.entities.Payment;
import com.datricle.project.uber.UberApp.entities.Ride;
import com.datricle.project.uber.UberApp.repositories.PaymentRepository;
import com.datricle.project.uber.UberApp.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {






    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment) {

    }

    @Override
    public Payment createNewPayment(Ride ride) {
        return null;
    }
}
