package com.harald.spring_modulith_events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.harald.spring_modulith_events.event.CreateActivityEvent;

@Component
 class CreateActivityEventListener {

	@ApplicationModuleListener
	public void onCreateActivityEvent(CreateActivityEvent event) throws InterruptedException {
		System.out.println("onCreateActivityEvent: " + event.toString());
		Thread.sleep(550);
		System.out.println("Finished CreateActivityEvent: " + event.toString());

	}
}
