package com.nanum.nanumserver.user.presentation;

import com.nanum.nanumserver.user.application.LoginService;
import com.nanum.nanumserver.user.application.UserService;
import com.nanum.nanumserver.user.dto.request.SignInRequest;
import com.nanum.nanumserver.user.dto.request.SignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/users")
    public ResponseEntity<Void> register(@Validated @RequestBody SignUpRequest signUpRequest) {
        userService.signUP(signUpRequest);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Validated @RequestBody SignInRequest request) {
        loginService.login(request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        loginService.logout();
        return ResponseEntity.noContent().build();
    }

    // 유저 검색
    // 내 계정 검색




}
