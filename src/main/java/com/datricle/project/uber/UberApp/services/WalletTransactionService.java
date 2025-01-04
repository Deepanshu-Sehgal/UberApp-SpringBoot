package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.dto.WalletTransactionDto;
import com.datricle.project.uber.UberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
