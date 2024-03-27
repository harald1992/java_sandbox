package com.harald.reactivespringmonofluxh2.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDto {
    private String title;

    private byte[] content;
}
