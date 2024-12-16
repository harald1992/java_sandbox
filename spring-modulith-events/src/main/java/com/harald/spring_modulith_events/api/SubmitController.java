package com.harald.spring_modulith_events.api;

import java.time.Duration;

import jakarta.annotation.PostConstruct;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harald.spring_modulith_events.dto.UserDetailsDto;
import com.harald.spring_modulith_events.event.CreateActivityEvent;
import com.harald.spring_modulith_events.event.GeneratePdfEvent;
import com.harald.spring_modulith_events.event.UpdateContactDetailsEvent;

@RestController
@RequestMapping("/api/submit")
public class SubmitController {

	private final ApplicationEventPublisher publisher;
	private final IncompleteEventPublications incompleteEvents;
	private final CompletedEventPublications completeEvents;

	public SubmitController(ApplicationEventPublisher publisher, IncompleteEventPublications incompleteEvents, CompletedEventPublications completeEvents) {
		this.publisher = publisher;
		this.incompleteEvents = incompleteEvents;
		this.completeEvents = completeEvents;
	}

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	protected void lala() throws InterruptedException {
//		Thread.sleep(Duration.ofSeconds(5).toMillis());
		incompleteEvents.resubmitIncompletePublications(p -> {
			ApplicationEvent event2 = ((PayloadApplicationEvent<ApplicationEvent>)p.getApplicationEvent()).getPayload();
//			publisher.publishEvent(event2);
			return true;
//			return false;
		});
	}

	@PostMapping
	@Transactional
	public void submit(@RequestBody final UserDetailsDto user) {

//		updateContactDetailsEvent(user);
		publisher.publishEvent(new UpdateContactDetailsEvent(this, user));
		publisher.publishEvent(new GeneratePdfEvent(this, user));

		publisher.publishEvent(new CreateActivityEvent(this));

		// update db
//		      .generateAndShareDossierSummary() // takes long
//				.pipe(
//						concatMap(() => this.activityService.postActivities()), // can we revert/undo this if some of our stuff fails
//				concatMap(() => this.processService.validateDossier()), // should be quick

	}
//
//	@Transactional
//	public void updateContactDetailsEvent(UserDetailsDto user) {
//		publisher.publishEvent(new UpdateContactDetailsEvent(this, user));
//
//	}

}
