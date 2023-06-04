package com.intuit.playermicroservice.model;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PlayerErrorResponse {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime timestamp;
    private int status;
    private String path;
    private String error;

    public PlayerErrorResponse(ZonedDateTime timestamp, int statusCode, String path, String message) {
        super();
        this.timestamp = timestamp;
        this.status = statusCode;
        this.path = path;
        this.error = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int statusCode) {
        this.status = statusCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}