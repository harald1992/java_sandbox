package com.harald.jwtauth.repository;

import com.harald.jwtauth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<List<Role>> findAllByName(String name);

}
