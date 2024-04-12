package com.harald.jwtauth.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        char[] chars = rawPassword.toString().toCharArray(); // Convert CharSequence to char array

        for (int i = 0; i < chars.length; i++) {
            chars[i]++; // Increment the character by one
        }
        return new String(chars).toUpperCase(); // Convert the char array back to a String and do toUpperCase()

    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

}
