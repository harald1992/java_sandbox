package com.harald.jwteducationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructor_detail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDetail {

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    // makes it uni-directional, look at instructorDetail property in the Instructor class.
    private Instructor instructor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    private String hobby;

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'';
    }

}
