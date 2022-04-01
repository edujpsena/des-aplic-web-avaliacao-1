package com.example.ted.exception.handler;

import com.example.ted.exception.ErrorMessage;
import com.example.ted.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage error = ErrorMessage
                .builder()
                .date(new Date())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .error("Resource not found")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage error = ErrorMessage
                .builder()
                .date(new Date())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Global Exception")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .build();

        return  new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
