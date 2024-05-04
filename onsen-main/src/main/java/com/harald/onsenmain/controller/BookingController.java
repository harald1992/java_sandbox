package com.harald.onsenmain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.harald.onsenmain.constants.EndpointConstants.API_BOOKING_URL;

@RestController
@RequestMapping(API_BOOKING_URL)
public class BookingController {


    @GetMapping()
    public ResponseEntity<String> getBooking() {
        return ResponseEntity.ok("Booking protected");
    }

}
