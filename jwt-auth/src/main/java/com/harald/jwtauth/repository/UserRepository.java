package com.harald.jwtauth.repository;

import com.harald.jwtauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findFirstById(Long id);
    Boolean existsByUsername(String username);

}
