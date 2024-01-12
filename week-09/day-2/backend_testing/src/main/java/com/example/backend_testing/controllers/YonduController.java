package com.example.backend_testing.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YonduController {


    @GetMapping("/yondu")
    public ResponseEntity<?> getArrow(@RequestParam(required = false) Double distance, @RequestParam(required = false) Double time) {
        if (distance != null && time != null) {
            return ResponseEntity.ok(new YonduResponse(distance, time));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse());
    }
}