package com.harald.onsenauthservice.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        // TODO: implement fetching current user if needed.
        return Optional.of("NO_USER_SET_YET");
    }

}
