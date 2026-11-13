package com.backend.springbootpractice.demo5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("jdbcStudentRunner")
public class StudentRunner implements CommandLineRunner {
    private StudentRepository studentRepository;

    public StudentRunner(@Qualifier("jdbcStudentRepository") StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String[] args) {
        Student stud = new Student("Aarav", 105);
        Student stud1 = new Student("Priya", 106);

        studentRepository.save(stud);
        studentRepository.save(stud1);

        List<Student> students = studentRepository.findAll();
        for (Student s : students) {
            System.out.println("Roll: " + s.getRoll()
                    + ", Name: " + s.getName());
        }

    }
}
