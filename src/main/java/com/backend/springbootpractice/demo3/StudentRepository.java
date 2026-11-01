package com.backend.springbootpractice.demo3;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> mapper = (rs, rowNum) -> new Student(
            rs.getInt("Id"),
            rs.getString("Name"),
            rs.getString("Email"),
            rs.getInt("Age")
    );

    public void save(Student s) {
        String sql = "INSERT INTO Students(name , email , age) VALUES(? , ? , ?)";
        jdbcTemplate.update(sql, s.getName(), s.getEmail(), s.getAge());
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM Students ORDER BY id";
        return jdbcTemplate.query(sql, mapper);
    }

    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        List<Student> list = jdbcTemplate.query(sql, mapper, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public void update(Student s) {
        String sql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, s.getName(), s.getEmail(), s.getAge(), s.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
