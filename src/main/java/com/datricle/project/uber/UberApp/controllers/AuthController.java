package com.datricle.project.uber.UberApp.controllers;

import com.datricle.project.uber.UberApp.dto.SignUpDto;
import com.datricle.project.uber.UberApp.dto.UserDto;
import com.datricle.project.uber.UberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignUpDto signupDto) {
        return authService.signup(signupDto);
    }

}
