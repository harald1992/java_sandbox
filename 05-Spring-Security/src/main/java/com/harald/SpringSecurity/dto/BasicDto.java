package com.harald.SpringSecurity.dto;

import org.springframework.stereotype.Component;

@Component
public class BasicDto {
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
