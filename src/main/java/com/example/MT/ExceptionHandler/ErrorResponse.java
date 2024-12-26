package com.example.MT.ExceptionHandler;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(String message){
        this.message = message;
        this.timeStamp=LocalDateTime.now();
    }

}
