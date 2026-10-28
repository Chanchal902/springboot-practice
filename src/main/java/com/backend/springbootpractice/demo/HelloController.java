package com.backend.springbootpractice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String msg() {
        return "Hello Spring Boot!";
    }
}
