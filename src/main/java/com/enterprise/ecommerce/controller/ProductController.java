package com.enterprise.ecommerce.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.enterprise.ecommerce.entity.Product;
import com.enterprise.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

}
