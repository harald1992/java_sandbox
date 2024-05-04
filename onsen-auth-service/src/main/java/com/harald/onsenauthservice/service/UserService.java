package com.harald.onsenauthservice.service;

import com.harald.onsenauthservice.entity.Role;
// import com.harald.jwtauth.entity.SecureToken;
import com.harald.onsenauthservice.entity.UserDetailsImpl;
import com.harald.onsenauthservice.error.ApiException;
import com.harald.onsenauthservice.repository.RoleRepository;
import com.harald.onsenauthservice.repository.UserRepository;
import com.harald.jwtshared.dto.AuthRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    // private final SecureTokenService secureTokenService;

    private final EmailService emailService;

    // todo: create correct exception.
    public void registerUser(AuthRequestDto authRequestDto) throws RuntimeException {
        if (userRepository.existsByUsername(authRequestDto.getUsername())) {
            throw new ApiException("User already exists");
        }

        UserDetailsImpl userDetailsImpl = new UserDetailsImpl();

        BeanUtils.copyProperties(authRequestDto, userDetailsImpl);
        userDetailsImpl.setPassword(passwordEncoder.encode((authRequestDto.getPassword())));
        userDetailsImpl.setEnabled(true);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        userDetailsImpl.setRoles(Set.of(adminRole));

        UserDetailsImpl newUserDetailsImpl = userRepository.save(userDetailsImpl);
        // sendRegistrationConfirmationEmail(newUser);
    }

    public List<UserDetailsImpl> getUserList() {
        return userRepository.findAll();
    }


    // public void sendRegistrationConfirmationEmail(User user) {
    //     SecureToken secureToken = secureTokenService.createSecureToken();
    //     secureToken.setUser(user);
    //     secureTokenService.saveToken(secureToken);
    //
    //     try {
    //         emailService.sendEmail(
    //                 new RegistrationEmail(
    //                         user.getUsername(),
    //                         "Confirm your registration here",
    //                         "jwt-auth@example.com",
    //                         "This is your token: " + secureToken.getToken()
    //                 ));
    //         // todo: verification url etc to complete registration. This url also needs to be a webpage I guess?
    //     } catch (
    //             RuntimeException e) {
    //         e.printStackTrace();
    //     }
    // }
    //
    // complete registration
    // public boolean verifyUser(String token) {
    //     SecureToken secureToken = secureTokenService.findByToken(token).orElse(null);
    //     if (secureToken == null) {
    //         return false;
    //     }
    //
    //
    //     User user = userRepository.findFirstById(secureToken.getUser().getId()).orElse(null);
    //     if (user == null) {
    //         return false;
    //     }
    //
    //     user.setAccountVerified(true);
    //     userRepository.save(user);
    //
    //     secureTokenService.removeByToken(token);
    //
    //     return true;
    //
    // }

}
