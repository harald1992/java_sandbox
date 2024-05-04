package com.harald.onsenauthservice.context;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AbstractEmailContext {
    // if you will have different email types you can extend this, and cannot use this directly since abstract class.

    private String to;

    private String subject;

    private String from;

    private String content;


}
