package com.example.backend_testing.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

    @GetMapping("/groot")
    public ResponseEntity<Object> grootTranslation(@RequestParam(required = false) String message) {
        if (message != null && !message.isEmpty()) {
            return ResponseEntity.ok(new GrootResponse(message));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse());

    }
}
