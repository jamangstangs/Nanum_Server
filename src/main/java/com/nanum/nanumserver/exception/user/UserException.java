package com.nanum.nanumserver.exception.user;

import com.nanum.nanumserver.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class UserException extends ApplicationException {
    public UserException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
