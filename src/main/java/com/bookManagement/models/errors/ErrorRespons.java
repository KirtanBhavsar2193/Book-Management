package com.bookManagement.models.errors;

import java.time.LocalDateTime;

public class ErrorRespons {

    private String message;
    private ErrorType type;
    private LocalDateTime timeStamp;

    public ErrorRespons(String message, ErrorType type) {
        this.message = message;
        this.type = type;
        this.timeStamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
