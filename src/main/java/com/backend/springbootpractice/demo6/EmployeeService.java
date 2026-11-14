package com.backend.springbootpractice.demo6;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int saveEmployee(Employee employee) {
        if (employee.getSalary() <= 0) throw new IllegalArgumentException();
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public int updateEmployee(Employee employee) {
        if (employee.getSalary() <= 0) throw new IllegalArgumentException();
        return employeeRepository.update(employee);
    }

    public int deleteEmployeeById(int id) {
        return employeeRepository.deleteById(id);
    }
}
