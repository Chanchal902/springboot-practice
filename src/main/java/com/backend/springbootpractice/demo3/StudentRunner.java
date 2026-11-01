package com.backend.springbootpractice.demo3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRunner implements CommandLineRunner {
    private final StudentRepository repo;

    public StudentRunner(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String[] args) {
        repo.save(new Student("Riya", "riya@gmail.com", 22));
        List<Student> all = repo.findAll();
        for (Student s : all) {
            System.out.println(s);
        }

        int riyaId = all.get(all.size() - 1).getId();

        Student found = repo.findById(riyaId);
        System.out.println("Found: " + found);

        found.setAge(25);
        repo.update(found);
        System.out.println("After update: " + repo.findById(riyaId));

        repo.delete(riyaId);
        System.out.println("After delete: " + repo.findAll());
    }

}

