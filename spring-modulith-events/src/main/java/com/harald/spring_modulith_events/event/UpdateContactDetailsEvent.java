package com.harald.spring_modulith_events.event;

import org.springframework.context.ApplicationEvent;

import com.harald.spring_modulith_events.dto.UserDetailsDto;
import com.harald.spring_modulith_events.entity.UserDetails;

public class UpdateContactDetailsEvent extends ApplicationEvent {
	 UserDetailsDto userDetails;

	public UpdateContactDetailsEvent(Object source, UserDetailsDto userDetails) {
		super(source);
		this.userDetails = userDetails;
	}

//	public UpdateContactDetailsEvent(Object source) {
//		super(source);
//		this.userDetails = (UserDetailsDto) source;
//	}

	public UserDetailsDto getUserDetails() {
		return userDetails;
	}
}
