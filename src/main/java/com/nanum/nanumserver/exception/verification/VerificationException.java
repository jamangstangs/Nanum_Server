package com.nanum.nanumserver.exception.verification;

import com.nanum.nanumserver.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class VerificationException extends ApplicationException {
    public VerificationException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
