package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.dto.WalletTransactionDto;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransactionDto walletTransactionDto);
}
