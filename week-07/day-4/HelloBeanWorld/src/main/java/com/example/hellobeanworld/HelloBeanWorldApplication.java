package com.example.hellobeanworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloBeanWorldApplication implements CommandLineRunner {

    private final Printer printer;

    private final MyColor color;

    @Autowired
    HelloBeanWorldApplication(Printer printer, @Qualifier("red") MyColor color) {
        this.printer = printer;
        this.color = color;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloBeanWorldApplication.class, args);
    }

    @Override
    public void run(String... args) {
        printer.log("hello");
        color.printColor();
    }
}
