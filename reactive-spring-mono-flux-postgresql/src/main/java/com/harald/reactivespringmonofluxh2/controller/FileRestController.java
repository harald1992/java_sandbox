package com.harald.reactivespringmonofluxh2.controller;

import com.harald.reactivespringmonofluxh2.dto.FileDto;
import com.harald.reactivespringmonofluxh2.dto.UploadRequestDto;
import com.harald.reactivespringmonofluxh2.dto.UploadResponseDto;
import com.harald.reactivespringmonofluxh2.service.FileService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/file")
public class FileRestController {

    final FileService fileService;

    public FileRestController(final FileService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct()
    public void fillDatabaseWithFiles() {
        FileDto fileDto = FileDto.builder().title("test").content("lalalalala".getBytes()).build();
        fileService.save(fileDto);
    }

    @PostMapping(value ="/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UploadResponseDto> upload(@ModelAttribute final UploadRequestDto uploadRequestDto) {
        return ResponseEntity.ok(UploadResponseDto.builder().result("Completed").build());
    }

    @GetMapping()
    public List<FileDto> getAllFiles() {
        // return fileService.getAllFiles();
        return List.of(FileDto.builder().build());
    }

    @GetMapping("/test")
    public String getStuff() {
        return "lala";
    }

}
