package com.example.backend_testing.controllers;

public class GrootResponse {
    private String received;
    private String translated = "I am Groot!";

    public GrootResponse(String received) {
        this.received = received;
    }

    public String getReceived() {
        return received;
    }

    public String getTranslated() {
        return translated;
    }
}
