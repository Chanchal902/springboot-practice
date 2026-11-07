package com.backend.springbootpractice.demo4;

import org.springframework.stereotype.Component;

@Component
public class Students {
    private String name;
    private int roll;

    public Students() {
    }

    public Students(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
