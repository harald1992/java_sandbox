package com.harald.spring_modulith_events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.harald.spring_modulith_events.event.CreateActivityEvent;

@Component
public class CreateActivityEventListener {

	@EventListener
	public void onCreateActivityEvent(CreateActivityEvent event) {
		System.out.println("Received event: CreateActivityEvent");
	}
}
