package com.harald.SpringRestCrudAPIs.controllers;

import com.harald.SpringRestCrudAPIs.dto.StudentDTO;
import com.harald.SpringRestCrudAPIs.errorResponses.StudentErrorResponse;
import com.harald.SpringRestCrudAPIs.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<StudentDTO> students = new ArrayList<StudentDTO>();

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return students;
    }

    @PostConstruct
    public void setStudents() {
        for (int i = 0; i < 10; i++) {
            StudentDTO student = new StudentDTO(i, "MyStudentName", "student@example.com");
            students.add(student);
        }
    }

    @GetMapping("/students/trial/{id}")
    public StudentDTO getStudentById2(@PathVariable int id) throws Exception {
        try {
            return students.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Student not found");
        } catch (Exception e) {
            throw new Exception("An unknown error occurred");
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
        try {
            StudentDTO student = students.get(id);
            return ResponseEntity.ok(student);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/students/course/{id}")
    public ResponseEntity<StudentDTO> getStudentByIdCourse(@PathVariable int id) throws Exception {
       if (id < 0 || id > students.size()) {
           throw new StudentNotFoundException("student not found: " + id);
       }

       StudentDTO student = students.get(id);
        // If the try block executes without throwing an exception, return ResponseEntity.ok(student)
        return ResponseEntity.ok(student);
    }

    // better use global handler for this
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
    //
    //     StudentErrorResponse error = new StudentErrorResponse();
    //     error.setStatus(HttpStatus.NOT_FOUND.value());
    //     error.setMessage(e.getMessage());
    //     error.setTimeStamp(System.currentTimeMillis());
    //
    //     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // error is body
    // }

}
