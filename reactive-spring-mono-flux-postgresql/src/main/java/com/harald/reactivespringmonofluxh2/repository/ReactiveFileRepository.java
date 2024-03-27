package com.harald.reactivespringmonofluxh2.repository;

import com.harald.reactivespringmonofluxh2.entity.FileEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// public interface ReactiveFileRepository extends R2dbcRepository<FileEntity, Long> {
public interface ReactiveFileRepository extends ReactiveCrudRepository<FileEntity, Long> {

    Mono<FileEntity> findByTitleIgnoreCase(String title);

}
