package com.nanum.nanumserver.exception.item;

import com.nanum.nanumserver.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ItemException extends ApplicationException {
    public ItemException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
