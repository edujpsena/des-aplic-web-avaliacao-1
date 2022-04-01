package com.example.ted.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorMessage {

    private Date date;
    private Integer statusCode;
    private String error;
    private String message;
    private String path;

}
