package com.harald.jwtauth.service;

import com.harald.jwtauth.entity.Role;
import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.error.ApiException;
import com.harald.jwtauth.repository.RoleRepository;
import com.harald.jwtauth.repository.UserRepository;
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

    // todo: create correct exception.
    public void registerUser(AuthRequestDto authRequestDto) throws RuntimeException {
        if (userRepository.existsByUsername(authRequestDto.getUsername())) {
         throw new ApiException("User already exists");
        }

        User user = new User();

        BeanUtils.copyProperties(authRequestDto, user);
        user.setPassword(passwordEncoder.encode((authRequestDto.getPassword())));
        user.setEnabled(true);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        user.setRoles(Set.of(adminRole));

        userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

}
