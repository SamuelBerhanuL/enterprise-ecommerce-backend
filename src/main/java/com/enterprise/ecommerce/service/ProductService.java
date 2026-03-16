package com.enterprise.ecommerce.service;

import org.springframework.stereotype.*;
import com.enterprise.ecommerce.entity.Product;
import com.enterprise.ecommerce.repository.ProductRepository;
import com.enterprise.ecommerce.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts(){

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(p -> new ProductDTO(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice()
                ))
                .collect(Collectors.toList());
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
