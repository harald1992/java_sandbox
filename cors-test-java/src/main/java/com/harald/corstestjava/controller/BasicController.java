package com.harald.corstestjava.controller;

import com.harald.corstestjava.dto.BasicDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {


    @GetMapping("/all")
    public ResponseEntity<BasicDto> returnResult() {
        BasicDto dto = new BasicDto();
        dto.setMessage("BASIC STRING");
        return ResponseEntity.ok(dto);
    }

}
