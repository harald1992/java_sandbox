package com.harald.jwtauthbff.error;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.harald.jwtauthbff.constants.ErrorMessages.AUTH_ERROR;
import static com.harald.jwtauthbff.constants.ErrorMessages.DEFAULT_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ApiError> handleAuthenticationError(@NonNull final AuthenticationException ae) {
        log.error(ae.getMessage(), ae);
        return new ResponseEntity<>(new ApiError(AUTH_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> handleException(@NonNull final Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ApiError(DEFAULT_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
