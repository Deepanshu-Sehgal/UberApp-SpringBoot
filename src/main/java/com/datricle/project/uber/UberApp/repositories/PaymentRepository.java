package com.datricle.project.uber.UberApp.repositories;

import com.datricle.project.uber.UberApp.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
