package com.nanum.nanumserver.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpdatePasswordByVerificationRequest {
    @Email
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String verificationCode;

    public UpdatePasswordByVerificationRequest() {
    }

    public UpdatePasswordByVerificationRequest(String username, String password, String verificationCode) {
        this.username = username;
        this.password = password;
        this.verificationCode = verificationCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
