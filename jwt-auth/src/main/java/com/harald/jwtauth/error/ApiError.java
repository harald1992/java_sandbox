package com.harald.jwtauth.error;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static com.harald.jwtauth.constants.ErrorMessages.DEFAULT_ERROR;

@Getter
@Slf4j
public class ApiError {

    private final Instant timestamp = Instant.now();

    private List<String> errors;

    public ApiError(final List<String> errors) {
        super();
        this.errors = errors;
    }

    public ApiError(final String error) {
        super();
        this.errors = Collections.singletonList(error);
    }

    public ApiError(final Exception ex) {
        this.errors.add(DEFAULT_ERROR);
    }

}
