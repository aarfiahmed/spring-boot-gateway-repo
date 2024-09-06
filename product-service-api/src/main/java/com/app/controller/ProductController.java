package com.app.controller;

import com.app.domain.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class ProductController {
    List<Product> products = new ArrayList<>();

    @GetMapping("/v1/products")
    public List<Product> getAllProducts() {
        log.info("returning all products");
        return products;
    }

    @GetMapping("/v1/products/{id}")
    public Product getProductById(@PathVariable Integer id) {
        log.info("returning  products of id {}", id);
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping("/v1/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        log.info("creating product {}",product);
        products.add(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
}
