package com.harald.spring_modulith_events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringModulithEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringModulithEventsApplication.class, args);
	}

	@EventListener
	public void handleEvent(ApplicationEvent event) {
//		System.out.println("Received Received event: " + event.toString());
	}

}

