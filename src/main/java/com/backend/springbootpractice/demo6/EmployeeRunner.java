package com.backend.springbootpractice.demo6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeRunner implements CommandLineRunner {
    private final EmployeeService employeeService;

    public EmployeeRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String[] args) {
        Employee empp = new Employee("Rahul", "IT", 45000);
        int rowsInserted = employeeService.saveEmployee(empp);
        System.out.println("Number of Inserted rows: " + rowsInserted);

        List<Employee> e = employeeService.findAllEmployees();
        for (Employee empl : e) {
            System.out.println("Id: " + empl.getId()
                    + ", Name: " + empl.getName()
                    + ", Department: " + empl.getDepartment()
                    + ", Salary: " + empl.getSalary());
        }

        List<Employee> employees = employeeService.findAllEmployees();
        int id = employees.get(0).getId();
        System.out.println("First Employee id: " + id);

        Employee ee = employeeService.findEmployeeById(id);

        System.out.println("Id: " + ee.getId()
                + ", Name: " + ee.getName()
                + ", Department: " + ee.getDepartment()
                + ", Salary: " + ee.getSalary());

        // Update Employee
        Employee updatedEmployee = new Employee(id, "Rahul Sharma", "HR", 55000);

        int rowsUpdated = employeeService.updateEmployee(updatedEmployee);

        System.out.println("Number of Updated rows: " + rowsUpdated);

        // Delete Employee
        int rowsDeleted = employeeService.deleteEmployeeById(id);

        System.out.println("Number of Deleted rows: " + rowsDeleted);

        // Test EmptyResultDataAccessException
        try {
            employeeService.findEmployeeById(999999);
        } catch (EmptyResultDataAccessException es) {
            System.out.println("Employee not found for the given ID.");
        }
    }
}
