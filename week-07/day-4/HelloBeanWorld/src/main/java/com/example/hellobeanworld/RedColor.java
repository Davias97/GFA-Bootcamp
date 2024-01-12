package com.example.hellobeanworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("red")
public class RedColor implements MyColor {

    @Autowired
    private Printer printer;

    @Override
    public void printColor() {
        printer.log("It is red in color...");
    }
}
