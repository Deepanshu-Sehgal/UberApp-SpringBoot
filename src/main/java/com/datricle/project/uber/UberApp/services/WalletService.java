package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.entities.Ride;
import com.datricle.project.uber.UberApp.entities.User;
import com.datricle.project.uber.UberApp.entities.Wallet;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount,String transactionId, Ride ride);

    Wallet deductMoneyFromWallet(User user, Double amount);

    void withdrawMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
