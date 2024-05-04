package com.harald.jwteducationsystem.service;


import com.harald.jwteducationsystem.entity.Course;
import com.harald.jwteducationsystem.entity.Instructor;
import com.harald.jwteducationsystem.entity.InstructorDetail;
import com.harald.jwteducationsystem.repository.CourseRepository;
import com.harald.jwteducationsystem.repository.InstructorDetailRepository;
import com.harald.jwteducationsystem.repository.InstructorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

    private final InstructorDetailRepository instructorDetailRepository;

    private final CourseRepository courseRepository;

    @PostConstruct
    private void dataBaseTryout() {
        Instructor newInstructor = createInstructor();

        // Instructor foundInstructor = instructorRepository.findInstructorByIdAndEmail(newInstructor.getId(), newInstructor.getEmail()).orElseThrow();
        // System.out.println("Instructor found: " + foundInstructor);
        //
        // InstructorDetail found = instructorDetailRepository.findInstructorDetailByInstructorFirstName(newInstructor.getFirstName()).orElseThrow();
        // System.out.println("InstructorDetail found from instructor detail: " + found);
        // instructorDetailRepository.deleteByInstructor_FirstName(newInstructor.getFirstName());
        //
        // Optional<InstructorDetail> notFound = instructorDetailRepository.findInstructorDetailByInstructorFirstName("Chad");
        // System.out.println("Should be empty because deleted " + notFound);


    }

    private Instructor createInstructor() {
        Instructor tempInstructor = Instructor.builder().firstName("Chad").lastName("Darby").email("darby@example.com").build();

        InstructorDetail instructorDetail = InstructorDetail.builder().youtubeChannel("https://youtube.com/darby").hobby("Swimming").build();
        tempInstructor.setInstructorDetail(instructorDetail);

        Course course1 = Course.builder().title("Hibernate course").build();
        Course course2 = Course.builder().title("Java course").build();

        tempInstructor.addCourse(course1);
        tempInstructor.addCourse(course2);


        Instructor newInstructor = instructorRepository.save(tempInstructor);
        System.out.println("Instructor added to db:" + newInstructor);
        return newInstructor;
    }

}
