package com.harald.jwteducationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private short stars;

    private String comment;

    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;
}
