package com.greenfoxacademy.springstart.controllers;

public class Greeting {

    public long getId() {
        return id;
    }

    private long id;
    private String content;

    public String getContent() {
        return content;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
