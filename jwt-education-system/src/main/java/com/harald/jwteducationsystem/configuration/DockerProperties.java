package com.harald.jwteducationsystem.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "docker")
public class DockerProperties {

    private String path = "/Users/haraldhiemstra/.rd/bin/docker";

    // Getter and setter for 'path'

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
