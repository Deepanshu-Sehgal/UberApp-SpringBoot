package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.dto.DriverDto;
import com.datricle.project.uber.UberApp.dto.SignUpDto;
import com.datricle.project.uber.UberApp.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password); //return tokens

    UserDto signup(SignUpDto signUpDto);

    DriverDto onBoardNewDriver(Long userId, String vehicleId);
}
