package com.harald.spring_modulith_events;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityTests {

	static ApplicationModules modules = ApplicationModules.of(SpringModulithEventsApplication.class);

	@Test
	void verifiesModularStructure() {
		modules.verify();
	}
}
