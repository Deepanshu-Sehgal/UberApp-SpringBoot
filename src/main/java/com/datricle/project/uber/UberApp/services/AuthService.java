package com.datricle.project.uber.UberApp.services;

import com.datricle.project.uber.UberApp.dto.SignUpDto;
import com.datricle.project.uber.UberApp.dto.UserDto;

public interface AuthService {

    String login(String email,String password);
    UserDto signup(SignUpDto signUpDto);
}
