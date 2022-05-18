package com.nanum.nanumserver.exception.verification;

import org.springframework.http.HttpStatus;

public class NoSuchVerificationCodeException extends VerificationException {
    private static final String MESSAGE = "존재하지 않는 인증코드 입니다.";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    public NoSuchVerificationCodeException() {
        super(MESSAGE, HTTP_STATUS);
    }
}
