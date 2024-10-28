package com.harald.onsenauthservice.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

// CAN NOW USE @CreationTimestamp and @UpdateTimestamp pricate Instant creationTime instead of this

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // When an entity lifecycle event occurs, such as before persisting, updating, or deleting an entity, the corresponding listener methods in the specified listener classes are invoked.
@Data
public class Auditable {

    @CreatedDate    // spring data framework
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
