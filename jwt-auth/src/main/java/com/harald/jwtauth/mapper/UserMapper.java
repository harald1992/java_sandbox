package com.harald.jwtauth.mapper;

import com.harald.jwtauth.dto.UserDto;
import com.harald.jwtauth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    UserDto toUserDto(final User user);

    @Mapping(source = "username", target = "username")
    User toUser(final UserDto user);

}
