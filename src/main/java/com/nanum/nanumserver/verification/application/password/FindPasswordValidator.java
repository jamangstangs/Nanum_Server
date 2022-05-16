package com.nanum.nanumserver.verification.application.password;

public interface FindPasswordValidator {
    void checkIsVerified(String username, String verificationCode);
}
