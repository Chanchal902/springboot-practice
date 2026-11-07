package com.backend.springbootpractice.demo4;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentsRepository {
    ArrayList<Students> arrayList = new ArrayList<>();

    public void save(Students students) {
        arrayList.add(students);
    }

    public void print() {
        for (Students students : arrayList) {
            System.out.println("Name: " + students.getName()
                    + ", Roll: " + students.getRoll());
        }
    }
}
