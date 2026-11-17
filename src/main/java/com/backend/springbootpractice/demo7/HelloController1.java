package com.backend.springbootpractice.demo7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

    @GetMapping("/helloo")
    public String hello() {
        return "HELLO , Spring Boot!";
    }
}
