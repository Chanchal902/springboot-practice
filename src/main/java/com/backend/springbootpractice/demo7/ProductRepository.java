package com.backend.springbootpractice.demo7;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        RowMapper<Product> rowMapper = ((rs, rowNum) -> {
            return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("category"));
        });
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        RowMapper<Product> rowMapper = ((rs, rowNum) -> {
            return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("category"));
        });
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<Product> findByCategory(String category) {
        String sql = "SELECT * FROM products WHERE category = ?";
        RowMapper<Product> rowMapper = ((rs, rowNum) -> {
            return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"), rs.getString("category"));
        });
        return jdbcTemplate.query(sql, rowMapper, category);
    }
}
