package com.harald.jwtauth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="my_users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

}
