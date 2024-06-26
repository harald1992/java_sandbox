package com.harald.onsenmain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("onsen-auth-service")  // should align with eureka server names, and does load balancing under the hood
public interface AuthServiceFeignClient {

    @GetMapping("/api/v1/users")
    ResponseEntity<List<String>> getUserNames();

}
