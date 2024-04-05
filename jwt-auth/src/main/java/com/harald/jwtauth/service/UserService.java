package com.harald.jwtauth.service;

import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.helpers.CustomUserDetails;
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
public class UserService implements UserDetailsService {

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
        log.info("Load user by username: " + username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));
        CustomUserDetails userDetails = new CustomUserDetails(user);
        System.out.println("password user in loadUserByUsername = " + user.getPassword());

        System.out.println("password in loadUserByUsername = " + userDetails.getPassword());
        return userDetails;
    }


    // public UserService(final UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    // public List<UserDto> getUserList() {
    //     List<User> result = userRepository.findAll();
    //     List<UserDto> userList = new ArrayList<>();
    //
    //     for (User user : result) {
    //         userList.add(UserMapper.INSTANCE.toUserDto(user));
    //     }
    //     return userList;
    // }
    //
    // public void addUser(UserDto userDto) {
    //     User user = UserMapper.INSTANCE.toUser(userDto);
    //     userRepository.save(user);
    // }
    //
    // public void deleteAll() {
    //     userRepository.deleteAll();
    // }
}
