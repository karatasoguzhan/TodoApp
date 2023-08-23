package com.oguzhankaratas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 400: Kötü istek
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {super(message);}
}
