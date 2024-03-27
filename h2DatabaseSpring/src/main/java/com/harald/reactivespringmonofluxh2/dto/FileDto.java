package com.harald.reactivespringmonofluxh2.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class FileDto {
    private String title;

    private byte[] content;
}
