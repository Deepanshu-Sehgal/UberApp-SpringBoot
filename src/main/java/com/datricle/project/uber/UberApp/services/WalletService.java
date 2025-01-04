package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.entities.User;
import com.datricle.project.uber.UberApp.entities.Wallet;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount);

    void withdrawMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);
}
