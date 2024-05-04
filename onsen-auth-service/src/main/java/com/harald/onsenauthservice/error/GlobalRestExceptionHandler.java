package com.harald.onsenauthservice.error;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.harald.onsenauthservice.constants.ErrorMessages.AUTH_ERROR;
import static com.harald.onsenauthservice.constants.ErrorMessages.DEFAULT_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NotNull MethodArgumentNotValidException ex,
            @NotNull HttpHeaders headers,
            @NotNull HttpStatusCode status,
            @NotNull WebRequest request) {
        log.error(ex.getMessage(), ex);

        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            log.error("Error in the whole dto: " + error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ApiError apiError =
                new ApiError(errors);
        return handleExceptionInternal(
                ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiError> handleException(@NonNull final ApiException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ApiError(ex), ex.getHttpStatus());
    }

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
