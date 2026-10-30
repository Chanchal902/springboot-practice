package com.backend.springbootpractice.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Detail {
    @Value("${say.name}")
    private String sayName;

    @GetMapping("/meet")
    public String print() {
        return "Hello! " + sayName + " Nice to meet you!";
    }
}
