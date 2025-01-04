package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.entities.Ride;
import com.datricle.project.uber.UberApp.entities.User;
import com.datricle.project.uber.UberApp.entities.Wallet;
import com.datricle.project.uber.UberApp.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
