package com.harald.reactivespringmonofluxh2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="myTable")
@Data
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Lob    // to store BLOB to database
    @Column(name="content", columnDefinition = "BLOB")
    private byte[] content;
}
