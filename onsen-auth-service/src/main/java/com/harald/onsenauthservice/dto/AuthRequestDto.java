package com.harald.onsenauthservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(
        // name = "AuthRequestDto",
        description = "The required items needed to log in or register. Remember me is optional."
)
public class AuthRequestDto {

    @Schema(
            description = "Username",
            example = "Username"
    )
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Schema(
            description = "Password",
            example = "Password123"
    )
    @NotBlank(message = "password is mandatory")
    private String password;

    @Schema(
            description = "used to remember me in the ui so it keeps the cookie. (but this needs to be done in the gateway I think)."
    )
    private Boolean rememberMe;

}