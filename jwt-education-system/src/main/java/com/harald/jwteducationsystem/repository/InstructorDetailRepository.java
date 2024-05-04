package com.harald.jwteducationsystem.repository;

import com.harald.jwteducationsystem.entity.InstructorDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {

    @Transactional
    void deleteByInstructor_FirstName(String firstName);

    Optional<InstructorDetail> findInstructorDetailByInstructorFirstName(String firstName);
}
