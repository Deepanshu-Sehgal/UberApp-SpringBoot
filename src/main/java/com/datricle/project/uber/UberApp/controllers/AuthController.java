package com.datricle.project.uber.UberApp.controllers;

import com.datricle.project.uber.UberApp.dto.*;
import com.datricle.project.uber.UberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @PostMapping("/onBoardNewDriver{userId}")
    ResponseEntity<DriverDto> onBoardNewDriver(@PathVariable Long userId, @RequestBody OnBoardingDriverDto onBoardingDriverDto) {
        return new ResponseEntity<>(authService.onBoardNewDriver(userId,
                onBoardingDriverDto.getVehicleId()), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        String tokens[] = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }

}
