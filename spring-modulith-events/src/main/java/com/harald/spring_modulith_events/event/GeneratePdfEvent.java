package com.harald.spring_modulith_events.event;

import org.springframework.context.ApplicationEvent;

import com.harald.spring_modulith_events.dto.UserDetailsDto;
	// can actually convert to record, no need for applicationEvent anymore. Alltough then listeners that listen to ApplicationEvent superclasses will not work anymore and it also doesn't seem to be saved in the events_publication table anymore.
public class GeneratePdfEvent extends ApplicationEvent {
	UserDetailsDto userDetails;

	public GeneratePdfEvent(Object source, UserDetailsDto userDetails) {
		super(source);
		this.userDetails = userDetails;
	}

	public UserDetailsDto getUserDetails() {
		return userDetails;
	}
}
