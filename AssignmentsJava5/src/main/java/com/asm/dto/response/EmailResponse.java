package com.asm.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class EmailResponse{
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> props;
}
