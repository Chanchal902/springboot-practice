package com.backend.springbootpractice;

import com.backend.springbootpractice.demo4.StudentsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootPracticeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        String[] var = SpringApplication.run(SpringbootPracticeApplication.class, args).getBeanDefinitionNames();
		for(String v : var){
			System.out.println(v);
		}
    }

    private StudentsService studentsService;

    public SpringbootPracticeApplication(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @Override
    public void run(String[] args) throws Exception {
        studentsService.addStudent("Chanchal", 748);
        studentsService.addStudent("Iram", 468);
		studentsService.printStudent();
    }
}
