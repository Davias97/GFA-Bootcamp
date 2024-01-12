package com.example.url_aliaser.DTOs;

public class ErrorDTO {
    public String getError() {
        return error;
    }

    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }
}
