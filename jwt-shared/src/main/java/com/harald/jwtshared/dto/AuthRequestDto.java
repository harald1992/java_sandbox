package com.harald.jwtshared.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestDto {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "password is mandatory")
    private String password;

}