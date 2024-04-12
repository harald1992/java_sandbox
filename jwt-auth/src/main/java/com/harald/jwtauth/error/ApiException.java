package com.harald.jwtauth.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    public ApiException(final String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApiException(final String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
