package com.harald.reactivespringmonofluxh2.service;

import com.harald.reactivespringmonofluxh2.dto.FileDto;
import com.harald.reactivespringmonofluxh2.entity.FileEntity;
import com.harald.reactivespringmonofluxh2.repository.ReactiveFileRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class FileService {

    private final ReactiveFileRepository fileRepository;

    public FileService(final ReactiveFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(FileDto fileDto) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setTitle(fileDto.getTitle());
        fileEntity.setContent(fileDto.getContent());
        fileRepository.save(fileEntity);
    }

    public Flux<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }
        // return fileRepository.findAll()
        //         .stream()
        //         .map(f -> FileDto.builder()
        //                     .title(f.getTitle())
        //                     .content(f.getContent())
        //                         .build())
        //                             .toList();
        // return List.of(FileDto.builder().build());

    public Mono<FileEntity> findByTitle(String title) {
        return fileRepository.findByTitleIgnoreCase(title);

    }

}
