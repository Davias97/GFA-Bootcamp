package com.example.rest.models;

public class Appenda {

    private String appended;

    public String getAppended() {
        return appended;
    }

    public Appenda(String appendable) {
        appended = appendable + "a";
    }
}
