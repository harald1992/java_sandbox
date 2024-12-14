package com.harald.spring_modulith_events.event;

import org.springframework.context.ApplicationEvent;

import com.harald.spring_modulith_events.dto.UserDetailsDto;

public class UpdateContactDetailsEvent extends ApplicationEvent {
	private final UserDetailsDto userDetails;

	public UpdateContactDetailsEvent(Object source, UserDetailsDto userDetails) {
		super(source);
		this.userDetails = userDetails;
	}

	public UserDetailsDto getUserDetails() {
		return userDetails;
	}
}
