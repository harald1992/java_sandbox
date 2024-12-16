package com.harald.spring_modulith_events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.harald.spring_modulith_events.dto.UserDetailsDto;
import com.harald.spring_modulith_events.entity.UserDetails;
import com.harald.spring_modulith_events.event.UpdateContactDetailsEvent;
import com.harald.spring_modulith_events.repository.UserDetailsRepository;

@Component
class UpdateContactDetailsEventListener {

	private final UserDetailsRepository userDetailsRepository;

	public UpdateContactDetailsEventListener(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

@ApplicationModuleListener
public void updateContactDetails(UpdateContactDetailsEvent event) throws InterruptedException {
	System.out.println("updateContactDetails contact details for user: " + event.getUserDetails().name());
		UserDetailsDto user = event.getUserDetails();
		UserDetails userDetails = new UserDetails(null, user.name(), user.email(), user.phone());

		Thread.sleep(2000);
//		throw new RuntimeException("Error in UpdateContactDetailsEventListener");
		userDetailsRepository.save(userDetails);
		System.out.println("Finished: Contact details updated for user: " + user.name());
	}
}
