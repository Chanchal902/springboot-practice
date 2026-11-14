package com.backend.springbootpractice.demo6;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Employee employee) {
        String sql = "INSERT INTO Emp(name , department , salary) VALUES(? , ? , ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM Emp";
        RowMapper<Employee> rowMapper = ((rs, rowNum) -> {
            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"), rs.getDouble("salary"));
        });
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Employee findById(int id) {
        String sql = "SELECT * FROM Emp WHERE id = ?";
        RowMapper<Employee> rowMapper = ((rs, rowNum) -> {
            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"), rs.getDouble("salary"));
        });
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public int update(Employee employee) {
        String sql = "UPDATE Emp SET name = ? , department = ? , salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM Emp WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
