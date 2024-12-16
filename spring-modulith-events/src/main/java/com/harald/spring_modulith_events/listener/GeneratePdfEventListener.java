package com.harald.spring_modulith_events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.harald.spring_modulith_events.event.GeneratePdfEvent;

@Component
public class GeneratePdfEventListener {

	@ApplicationModuleListener
	public void onGeneratePdfEvent(GeneratePdfEvent event) throws InterruptedException {
		System.out.println("onGeneratePdfEvent PDF Event: " + event.getUserDetails().name());
		Thread.sleep(1000);
		System.out.println("Finished: PDF generated for user: " + event.getUserDetails().name());
	}
}
