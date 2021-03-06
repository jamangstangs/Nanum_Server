package com.nanum.nanumserver.user.presentation;

import com.nanum.nanumserver.user.application.LoginService;
import com.nanum.nanumserver.user.application.UserService;
import com.nanum.nanumserver.user.domain.SimpleUser;
import com.nanum.nanumserver.user.dto.request.SignInRequest;
import com.nanum.nanumserver.user.dto.request.SignUpRequest;
import com.nanum.nanumserver.user.dto.request.UpdatePasswordByVerificationRequest;
import com.nanum.nanumserver.user.dto.request.UpdatePasswordRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/users")
    public ResponseEntity<Void> register(@Validated @RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);
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

    @PutMapping("/users/reset-password")
    public ResponseEntity<Void> updatePasswordByVerification(@Validated @RequestBody UpdatePasswordByVerificationRequest request) {
        userService.updatePasswordByVerificationCode(request);
        return ResponseEntity.noContent().build();
    }


}
