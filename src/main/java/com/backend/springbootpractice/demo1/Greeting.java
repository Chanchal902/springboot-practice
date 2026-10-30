package com.backend.springbootpractice.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    @Value("${welcome.salutation}")
    private String welcomeSalutation;

    @GetMapping("/convo")
    public String talk() {
        return welcomeSalutation + " Buddy! How Are You?";
    }
}
