package com.harald.onsenauthservice.controller;

import com.harald.onsenauthservice.dto.BuildInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.harald.onsenauthservice.constants.EndpointConstants.API_BUILD_INFO_URL;

@RestController
@RequestMapping(API_BUILD_INFO_URL)
@RequiredArgsConstructor
public class BuildInfoController {

    private final Environment environment;

    private final BuildInfoDto buildInfoDto;

    @GetMapping()
    public ResponseEntity<String> getEnvironmentData() {
        // String serverPort = environment.getProperty("server.port");  // can get info from application.properties.yaml
        // String javaVersion = environment.getProperty("JAVA_HOME"); // can also get from env files from the system
        return ResponseEntity.ok(buildInfoDto.toString());
    }

}
