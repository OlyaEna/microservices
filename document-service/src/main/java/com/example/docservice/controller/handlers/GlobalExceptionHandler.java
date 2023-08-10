package com.example.docservice.controller.handlers;

import com.example.docservice.exceptions.ExceptionResponse;
import com.example.docservice.exceptions.SameIdInFiveMinutes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(SameIdInFiveMinutes.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse catchNonUniqueException(SameIdInFiveMinutes exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }
}