package com.nanum.nanumserver.exception.verification;

import org.springframework.http.HttpStatus;

public class InvalidVerificationInfoException extends VerificationException {
    private static final String MESSAGE = "유효하지 않은 인증정보입니다. ";
    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public InvalidVerificationInfoException() {
        super(MESSAGE, HTTP_STATUS);
    }
}
