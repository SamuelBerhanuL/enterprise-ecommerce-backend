package com.enterprise.ecommerce.service;

import org.springframework.stereotype.*;
import com.enterprise.ecommerce.entity.Product;
import com.enterprise.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
