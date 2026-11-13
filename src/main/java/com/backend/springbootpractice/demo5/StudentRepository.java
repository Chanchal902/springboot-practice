package com.backend.springbootpractice.demo5;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jdbcStudentRepository")
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Student student) {
        String sql = "INSERT INTO Student(Roll , Name) VALUES(? , ?)";
        return jdbcTemplate.update(sql, student.getRoll(), student.getName());
    }

    // fetch
    public List<Student> findAll() {
        String sql = "SELECT * FROM Student";
        RowMapper<Student> rowMapper = (rs, rowNum) -> {
            return new Student(rs.getString("Name"), rs.getInt("Roll"));
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}
