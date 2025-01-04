package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.entities.User;
import com.datricle.project.uber.UberApp.entities.Wallet;
import com.datricle.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.datricle.project.uber.UberApp.repositories.WalletRepository;
import com.datricle.project.uber.UberApp.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public Wallet addMoneyToWallet(User user, Double amount) {
        Wallet wallet = walletRepository.findByUser(user)
                .orElseThrow(() -> new
                        ResourceNotFoundException("Wallet not found for user with this id:" + user.getId()));
        wallet.setBalance(wallet.getBalance() * amount);
        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("wallet not found with this wallet id: " + walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);

    }
}
