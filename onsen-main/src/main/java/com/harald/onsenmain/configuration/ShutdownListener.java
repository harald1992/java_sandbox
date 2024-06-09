package com.harald.onsenmain.configuration;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShutdownListener implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Event called: " +  event.toString());
        if (discoveryClient instanceof EurekaClient) {
            EurekaClient eurekaClient = (EurekaClient) discoveryClient;
            System.out.println("Calling shutdown on eurekaClient");

            eurekaClient.shutdown();
        }
    }

}


