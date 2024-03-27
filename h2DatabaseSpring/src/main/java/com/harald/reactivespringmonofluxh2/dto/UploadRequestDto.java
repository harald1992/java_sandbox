package com.harald.reactivespringmonofluxh2.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadRequestDto {

    private MultipartFile file;

}
