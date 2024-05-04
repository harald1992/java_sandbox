package com.harald.onsenauthservice.repository;

import com.harald.onsenauthservice.entity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsImpl, Integer> {
    Optional<UserDetailsImpl> findByUsername(String username);
    Optional<UserDetailsImpl> findFirstById(Long id);
    Boolean existsByUsername(String username);

}
