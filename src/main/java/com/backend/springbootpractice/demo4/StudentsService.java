package com.backend.springbootpractice.demo4;

import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public void addStudent(String name, int roll) {
        Students stud = new Students(name, roll);
        studentsRepository.save(stud);
    }

    public void printStudent() {
        studentsRepository.print();
    }
}
