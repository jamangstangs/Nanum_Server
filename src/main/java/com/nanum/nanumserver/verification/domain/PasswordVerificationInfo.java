package com.nanum.nanumserver.verification.domain;

import java.time.LocalDateTime;

public class PasswordVerificationInfo extends VerificationInfo {
    public PasswordVerificationInfo() {
    }

    public PasswordVerificationInfo(String username, String verificationCode) {
        super(username, verificationCode);
    }

    public PasswordVerificationInfo(Long id, String username, String verificationCode, LocalDateTime createdAt, LocalDateTime confirmedAt) {
        super(id, username, verificationCode, createdAt, confirmedAt);
    }
}
