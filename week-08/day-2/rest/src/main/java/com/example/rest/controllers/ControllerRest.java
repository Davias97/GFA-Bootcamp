package com.example.rest.controllers;

import com.example.rest.ErrorDTO;
import com.example.rest.models.*;
import com.example.rest.services.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RestController
public class ControllerRest {

    private LogService logService;

    public ControllerRest(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/doubling")
    public ResponseEntity<Object> getDoubledValue(@RequestParam Optional<Integer> input, HttpServletRequest endpoint) {

        if (input.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide an input!"));
        } else {
            logService.saveLog(new Log(endpoint.getRequestURI(), endpoint.getQueryString()));
            Doubled doubled = new Doubled(input.get());
            return ResponseEntity.ok().body(doubled);
        }
    }

    @GetMapping("/greeter")
    public ResponseEntity<Object> getGreeted(@RequestParam Optional<String> name, @RequestParam Optional<String> title) {

        if (name.isEmpty() && title.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide a name and a title!"));
        } else if (name.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide a name!"));
        } else if (title.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide a title!"));
        } else {
            Greeter greeter = new Greeter(name.get(), title.get());
            return ResponseEntity.ok().body(greeter);
        }
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<Object> getAppend(@PathVariable Optional<String> appendable, HttpServletRequest endpoint) {

        if (appendable.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide an input!"));
        } else {
            Appenda appenda = new Appenda(appendable.get());
            logService.saveLog(new Log(endpoint.getRequestURI(), appendable.get()));
            return ResponseEntity.ok().body(appenda);
        }
    }

    @PostMapping("/dountil/{operation}")
    public ResponseEntity<Object> doUntilOperation(@PathVariable Optional<String> operation, @RequestBody Dountil dountil) {
        if (dountil.getUntil() == 0) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide an input!"));
        }

        int until = dountil.getUntil();
        Dountil dountil1 = new Dountil();

        if (operation.equals("sum")) {
            dountil1.calculateSum(until);
            return ResponseEntity.ok().body(dountil1.getResult());
        }
        if (operation.equals("factor")) {
            dountil1.calculateFactorial(until);
            return ResponseEntity.ok().body(dountil1.getResult());
        }
        return null;
    }

    @PostMapping("/arrays")
    public ResponseEntity<?> handleArrayRequest(@RequestBody ArrayHandler request, HttpServletRequest endpoint) throws JsonProcessingException {
        if (request.getWhat() == null && request.getNumbers() == null) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide numbers and commands!"));
        } else if (request.getWhat() == null) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide what to do with the numbers!"));
        } else if (request.getNumbers() == null) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Please provide numbers!"));
        }

        ArrayHandlerResponse response = new ArrayHandlerResponse();

        switch (request.getWhat()) {
            case "sum":
                int sum = Arrays.stream(request.getNumbers()).sum();
                response.setResult(sum);
                break;
            case "multiply":
                int product = Arrays.stream(request.getNumbers()).reduce(1, (a, b) -> a * b);
                response.setResult(product);
                break;
            case "double":
                int[] doubledArray = Arrays.stream(request.getNumbers()).map(n -> n * 2).toArray();
                response.setResult(doubledArray);
                break;
            default:
                return ResponseEntity.badRequest().body(new ErrorDTO("Invalid 'what' command!"));
        }
        logService.saveLog(new Log(endpoint.getRequestURI(), request));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/log")
    public ResponseEntity<Object> getLogEntries() {

        return ResponseEntity.ok(logService.listLogs());
    }
}


