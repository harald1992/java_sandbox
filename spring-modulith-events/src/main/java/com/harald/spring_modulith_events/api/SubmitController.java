package com.harald.spring_modulith_events.api;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harald.spring_modulith_events.dto.UserDetailsDto;
import com.harald.spring_modulith_events.event.GeneratePdfEvent;
import com.harald.spring_modulith_events.event.UpdateContactDetailsEvent;

@RestController
@RequestMapping("/api/submit")
public class SubmitController {

	private final ApplicationEventPublisher publisher;

	public SubmitController(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@PostMapping
	public void submit(@RequestBody final UserDetailsDto user) {
		publisher.publishEvent(new UpdateContactDetailsEvent(this, user));
		publisher.publishEvent(new GeneratePdfEvent(this, user));


		// update db
//		      .generateAndShareDossierSummary() // takes long
//				.pipe(
//						concatMap(() => this.activityService.postActivities()), // can we revert/undo this if some of our stuff fails
//				concatMap(() => this.processService.validateDossier()), // should be quick

	}

}
