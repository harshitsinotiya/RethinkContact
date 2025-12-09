package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        String errorMessages = ex.getBindingResult()
                                 .getAllErrors()
                                 .stream()
                                 .map(error -> error.getDefaultMessage())
                                 .collect(Collectors.joining(", "));
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
}
