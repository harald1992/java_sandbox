package com.harald.spring_modulith_events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync
public class SpringModulithEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringModulithEventsApplication.class, args);
	}

	@EventListener
	public void handleEvent(PayloadApplicationEvent event) {
		System.out.println("Received event: " + event.toString() + " " +  event.getTimestamp());
	}

}

