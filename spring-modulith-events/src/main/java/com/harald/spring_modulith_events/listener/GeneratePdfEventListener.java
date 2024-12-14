package com.harald.spring_modulith_events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.harald.spring_modulith_events.event.GeneratePdfEvent;

@Component
public class GeneratePdfEventListener {

	@EventListener
	@Async
	public void onGeneratePdfEvent(GeneratePdfEvent event) throws InterruptedException {
		System.out.println("Received event: " + event.toString());
		Thread.sleep(1000);
		System.out.println("PDF generated for user: " + event.getUserDetails().name());
	}
}
