package com.datricle.project.uber.UberApp.strategies.impl;

import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.Payment;
import com.datricle.project.uber.UberApp.entities.enums.PaymentStatus;
import com.datricle.project.uber.UberApp.entities.enums.TransactionMethod;
import com.datricle.project.uber.UberApp.repositories.PaymentRepository;
import com.datricle.project.uber.UberApp.services.WalletService;
import com.datricle.project.uber.UberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider -> 100
//Driver -> 70 deduct 30 rs from drivers wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;
        walletService.deductMoneyFromWallet(
                driver.getUser(),
                platformCommission,
                null,
                payment.getRide(),
                TransactionMethod.RIDE);
        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
