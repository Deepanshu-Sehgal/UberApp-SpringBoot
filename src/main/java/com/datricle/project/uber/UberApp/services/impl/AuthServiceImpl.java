package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.dto.DriverDto;
import com.datricle.project.uber.UberApp.dto.SignUpDto;
import com.datricle.project.uber.UberApp.dto.UserDto;
import com.datricle.project.uber.UberApp.services.AuthService;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignUpDto signUpDto) {
        return null;
    }

    @Override
    public DriverDto onBoardNewDriver(Long userID) {
        return null;
    }
}
