package com.backend.springbootpractice.demo7;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(int id) {
        try {
            return productRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Product> findProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
