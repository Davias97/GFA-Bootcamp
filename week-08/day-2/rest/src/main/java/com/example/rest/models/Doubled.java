package com.example.rest.models;

public class Doubled {

    private int received;
    private int result;

    public Doubled(Integer input) {
        this.received = input;
        this.result = received * 2;
    }

    public int getReceived() {
        return received;
    }

    public int getResult() {
        return result;
    }
}

