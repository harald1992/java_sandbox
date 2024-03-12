package com.harald.jwtauth.service;

import com.harald.jwtauth.dto.UserDto;
import com.harald.jwtauth.entity.User;
import com.harald.jwtauth.mapper.UserMapper;
import com.harald.jwtauth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUserList() {
        List<User> result = userRepository.findAll();
        List<UserDto> userList = new ArrayList<>();

        for (User user : result) {
            userList.add(UserMapper.INSTANCE.toUserDto(user));
        }
        return userList;
    }

    public void addUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        userRepository.save(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
