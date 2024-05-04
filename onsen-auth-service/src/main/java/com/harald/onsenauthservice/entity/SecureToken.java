// package com.harald.jwtauth.entity;
//
// import jakarta.persistence.*;
// import lombok.Data;
// import org.hibernate.annotations.CreationTimestamp;
//
// import java.sql.Timestamp;
// import java.time.LocalDateTime;
//
//
// @Entity
// @Table(name = "secure_token")
// @Data
// public class SecureToken {
//
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;
//
//     @Column(unique = true)
//     private String token;
//
//     @CreationTimestamp
//     @Column(updatable = false)
//     private Timestamp timestamp;
//
//     @Column(updatable = false)
//     @Basic(optional = false)
//     private LocalDateTime expireAt; // can also be done at runtime, it's a choice.
//
//     @ManyToOne  // not required for now, but later might be handy
//     @JoinColumn(name = "user_id", referencedColumnName = "id")
//     private User user;
//
//     @Transient
//     private boolean isExpired;
//
// }
