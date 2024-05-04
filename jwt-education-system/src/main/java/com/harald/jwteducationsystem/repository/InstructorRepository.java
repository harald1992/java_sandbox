package com.harald.jwteducationsystem.repository;

import com.harald.jwteducationsystem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findInstructorByIdAndEmail(long id, String email);

}
