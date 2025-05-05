package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Spring Boot Application!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "SuccessHeader");
        return new ResponseEntity<>("Success with custom header", headers, HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/resource/1");
        return new ResponseEntity<>("Created", headers, HttpStatus.CREATED);
    }
}
