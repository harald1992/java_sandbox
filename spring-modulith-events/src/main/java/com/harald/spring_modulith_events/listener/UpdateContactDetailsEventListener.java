package com.harald.spring_modulith_events.listener;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import com.harald.spring_modulith_events.dto.UserDetailsDto;
import com.harald.spring_modulith_events.entity.UserDetails;
import com.harald.spring_modulith_events.event.UpdateContactDetailsEvent;
import com.harald.spring_modulith_events.repository.UserDetailsRepository;

@Component
public class UpdateContactDetailsEventListener {

	private final UserDetailsRepository userDetailsRepository;

	public UpdateContactDetailsEventListener(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	@TransactionalEventListener
	@Transactional(propagation = Propagation.REQUIRES_NEW)  // needed to do DB work in a new transaction
	@Async
	public void updateContactDetails(UpdateContactDetailsEvent event) throws InterruptedException {
		System.out.println("Received event: " + event.toString());
		UserDetailsDto user = event.getUserDetails();
		UserDetails userDetails = new UserDetails(null, user.name(), user.email(), user.phone());

		Thread.sleep(200);
		userDetailsRepository.save(userDetails);
		System.out.println("Contact details updated for user: " + user.name());
	}
}
