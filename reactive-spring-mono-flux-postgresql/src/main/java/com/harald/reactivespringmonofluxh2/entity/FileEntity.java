package com.harald.reactivespringmonofluxh2.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// @Entity
// @Table(name ="myTable")
// no entity annotations because it is not jpa/jdbc implementation
@Data
@Table(name = "files")
public class FileEntity {

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column("title")
    private String title;

    @Column("content")
    private byte[] content;

}
