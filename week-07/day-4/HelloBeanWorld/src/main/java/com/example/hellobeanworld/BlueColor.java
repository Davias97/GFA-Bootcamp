package com.example.hellobeanworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("blue")
public class BlueColor implements MyColor {

    @Autowired
    private Printer printer;
    @Override
    public void printColor() {
        printer.log("It is blue in color...");
    }
}
