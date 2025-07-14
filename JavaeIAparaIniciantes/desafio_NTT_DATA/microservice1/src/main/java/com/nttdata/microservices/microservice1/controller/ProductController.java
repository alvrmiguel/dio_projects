package com.nttdata.microservices.microservice1.controller;

import com.nttdata.microservices.microservice1.Product;
import com.nttdata.microservices.microservice1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Criar produto
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Listar produtos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
