package com.harald.jwtauth.service;

import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * The loadUserByUsername method is an implementation of the loadUserByUsername method defined in the UserDetailsService interface.
     * This method is called by Spring Security when it needs to retrieve user details for authentication.
     *
     * @param username the username
     * @return the UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User email not found."));
        // return new CustomUserDetails(user);
        return user;
    }
}
