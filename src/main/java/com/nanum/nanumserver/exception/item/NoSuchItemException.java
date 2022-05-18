package com.nanum.nanumserver.exception.item;

import org.springframework.http.HttpStatus;

public class NoSuchItemException extends ItemException {
    private static final String MESSAGE = "해당 Item은 존재하지 않습니다.";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    public NoSuchItemException() {
        super(MESSAGE, HTTP_STATUS);
    }
}
