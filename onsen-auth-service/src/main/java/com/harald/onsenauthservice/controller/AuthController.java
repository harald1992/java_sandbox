package com.harald.onsenauthservice.controller;

import com.harald.onsenauthservice.dto.AuthRequestDto;
import com.harald.onsenauthservice.error.ApiError;
import com.harald.onsenauthservice.error.ApiException;
import com.harald.onsenauthservice.service.JwtService;
import com.harald.onsenauthservice.service.UserDetailsServiceImpl;
import com.harald.onsenauthservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.harald.onsenauthservice.constants.EndpointConstants.API_AUTH_URL;
import static com.harald.onsenauthservice.constants.ErrorMessages.AUTH_ERROR;

@RestController
@RequestMapping(API_AUTH_URL)
@RequiredArgsConstructor
@Slf4j
@Tag(
        name = "Auth endpoints",
        description = "Login, validate and register users"
)
public class AuthController {

    // private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final UserService userService;


    @Operation(
            summary = "Login the user and returns Jwt in the header.",
            description = "Creates jwt from the username in the authRequest and returns that in the Authorization header."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status ok."
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
    })
    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);   // what does this do?

        if (authentication.isAuthenticated()) {
            String jwt = jwtService.CreateJwt(authRequestDto.getUsername());
            return ResponseEntity.ok().header("Authorization", "Bearer " + jwt).build();

        } else {
            throw new ApiException(AUTH_ERROR, HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("register")
    @Operation(
            summary = "Register a new user"
            // description = ""
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http status created.",
                    content = @Content(
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
    })
    public ResponseEntity<String> register(@Valid @RequestBody AuthRequestDto authRequestDto) {
        userService.registerUser(authRequestDto);
        return new ResponseEntity<>("User registered success!", HttpStatus.CREATED);
    }


    @PostMapping("validate")
    @Operation(
            summary = "Validate User",
            description = "Validates the jwt"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status ok.",
                    content = @Content(
                            schema = @Schema(implementation = Boolean.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Http status Forbidden.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
    })
    public ResponseEntity<Boolean> validateJwt(@RequestBody String jwt) {
        boolean isValidToken = jwtService.isTokenValid(jwt);
        if (!isValidToken) {
            throw new ApiException(AUTH_ERROR, HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(true);
    }


}
