package com.datricle.project.uber.UberApp.controllers;

import com.datricle.project.uber.UberApp.dto.*;
import com.datricle.project.uber.UberApp.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

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
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
                                           HttpServletRequest servletRequest,
                                           HttpServletResponse servletResponse) {
        String tokens[] = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Cookie cookie  = new Cookie("token",tokens[1]);
        cookie.setHttpOnly(true);
        servletResponse.addCookie(cookie);

        return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }

}
