package com.enterprise.ecommerce.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.enterprise.ecommerce.entity.Product;
import com.enterprise.ecommerce.service.ProductService;
import com.enterprise.ecommerce.dto.ProductDTO;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
