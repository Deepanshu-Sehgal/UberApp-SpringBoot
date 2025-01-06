package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.dto.DriverDto;
import com.datricle.project.uber.UberApp.dto.SignUpDto;
import com.datricle.project.uber.UberApp.dto.UserDto;
import com.datricle.project.uber.UberApp.entities.Driver;
import com.datricle.project.uber.UberApp.entities.User;
import com.datricle.project.uber.UberApp.entities.enums.Role;
import com.datricle.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.datricle.project.uber.UberApp.exceptions.RuntimeConflictException;
import com.datricle.project.uber.UberApp.repositories.UserRepository;
import com.datricle.project.uber.UberApp.services.AuthService;
import com.datricle.project.uber.UberApp.services.DriverService;
import com.datricle.project.uber.UberApp.services.RiderService;
import com.datricle.project.uber.UberApp.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signup(SignUpDto signUpDto) {

        User user = userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if (user != null) {
            throw new RuntimeConflictException("Cannot signUp, User Already Exist with email " + signUpDto.getEmail());
        }


        User mappedUser = modelMapper.map(signUpDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);

        //create user related entities
        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id: " + userId));

        if (user.getRoles().contains(Role.DRIVER))
            throw new RuntimeException("User with id " + userId + "is already a Driver");

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();

        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }
}
