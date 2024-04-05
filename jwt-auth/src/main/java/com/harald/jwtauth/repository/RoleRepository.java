package com.harald.jwtauth.repository;

import com.harald.jwtauth.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByName(String name);

}
