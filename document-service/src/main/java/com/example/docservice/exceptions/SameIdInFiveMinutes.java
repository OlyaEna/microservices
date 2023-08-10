package com.example.docservice.exceptions;

public class SameIdInFiveMinutes extends RuntimeException{
    public SameIdInFiveMinutes(String message) {
        super(message);
    }
}
