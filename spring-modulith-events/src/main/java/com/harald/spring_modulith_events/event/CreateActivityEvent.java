package com.harald.spring_modulith_events.event;

import org.springframework.context.ApplicationEvent;

public class CreateActivityEvent extends ApplicationEvent {
	public CreateActivityEvent(Object source) {
		super(source);
	}
}
