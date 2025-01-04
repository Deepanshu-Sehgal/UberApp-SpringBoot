package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.entities.WalletTransaction;
import com.datricle.project.uber.UberApp.repositories.WalletTransactionRepository;
import com.datricle.project.uber.UberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        WalletTransaction walletTransaction = modelMapper.map(walletTransaction, WalletTransaction.class);
        walletTransactionRepository.save(walletTransaction);
    }
}
