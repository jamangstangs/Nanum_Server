package com.nanum.nanumserver.verification.application.signup;

public interface SignUpValidator {
    void checkIsVerified(String username, String verificationCode);
}
