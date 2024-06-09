package com.harald.onsenmain.controller;

import com.harald.onsenmain.client.AuthServiceFeignClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.harald.onsenmain.constants.EndpointConstants.API_BOOKING_URL;

@RestController
@RequestMapping(API_BOOKING_URL)
@RequiredArgsConstructor
public class BookingController {

    private final AuthServiceFeignClient authServiceFeignClient;

    @GetMapping("/users")
    public ResponseEntity<List<String>> callAuth() {
        try {
            var userNames = authServiceFeignClient.getUserNames();
            System.out.println("callAuth");
            for (String s : Objects.requireNonNull(userNames.getBody())) {
                System.out.println(s);
            }
            return userNames;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping()
    public ResponseEntity<String> getBooking() {
        return ResponseEntity.ok("Booking protected");
    }

}
