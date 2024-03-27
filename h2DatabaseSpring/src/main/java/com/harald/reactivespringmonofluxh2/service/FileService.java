package com.harald.reactivespringmonofluxh2.service;

import com.harald.reactivespringmonofluxh2.dto.FileDto;
import com.harald.reactivespringmonofluxh2.entity.FileEntity;
import com.harald.reactivespringmonofluxh2.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    final FileRepository fileRepository;

    public FileService(final FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(FileDto fileDto) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setTitle(fileDto.getTitle());
        fileEntity.setContent(fileDto.getContent());
        fileRepository.save(fileEntity);
    }

    public List<FileDto> getAllFiles() {
        return fileRepository.findAll()
                .stream()
                .map(f -> FileDto.builder()
                            .title(f.getTitle())
                            .content(f.getContent())
                                .build())
                                    .toList();

    }

}
