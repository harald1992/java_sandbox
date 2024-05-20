package com.harald.onsenmain.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "build-info")
@Data
public class BuildInfoDto { // cannot use record because that makes properties final and we need to refresh actuator
    private String appName;

    private String environment;

}
