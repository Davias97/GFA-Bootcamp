package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

    AtomicLong greetCount = new AtomicLong(0);
    @RequestMapping(value = "/greeting")
    public Greeting greetMethod(@RequestParam("name") String name) {
        return new Greeting(greetCount.incrementAndGet(), "Hello " + name);
    }
}
