package com.harald.corstestjava.controller;

import com.harald.corstestjava.dto.BasicDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "http://localhost:5500")
@RequestMapping("/basic")
public class BasicController {


    @GetMapping("/all")
    public ResponseEntity<BasicDto> returnResult() {
        BasicDto dto = new BasicDto();
        dto.setMessage("BASIC STRING");
        return ResponseEntity.ok(dto);
    }

}
