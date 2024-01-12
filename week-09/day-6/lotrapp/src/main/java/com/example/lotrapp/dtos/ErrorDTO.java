package com.example.lotrapp.dtos;

public class ErrorDTO {
    public String getError() {
        return error;
    }

    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }
}