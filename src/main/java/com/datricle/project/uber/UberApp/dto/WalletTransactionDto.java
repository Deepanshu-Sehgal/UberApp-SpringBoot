package com.datricle.project.uber.UberApp.dto;

import com.datricle.project.uber.UberApp.entities.enums.TransactionMethod;
import com.datricle.project.uber.UberApp.entities.enums.TransactionType;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class WalletTransactionDto {
    private Long id;
    private Double amount;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;
    private RideDto ride;
    private String transactionId;
    private WalletDto wallet;
    private LocalDateTime timeStamp;

}
