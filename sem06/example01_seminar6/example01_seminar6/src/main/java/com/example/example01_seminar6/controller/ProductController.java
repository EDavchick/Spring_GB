package com.example.example01_seminar6.controller;

import com.example.example01_seminar6.model.Product;
import com.example.example01_seminar6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id")Long id) {
        Product productById;
        try {
            productById = productService.getProductById(id);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Product not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Product());
        }
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
/*
    [
    {
        "id": 1,
        "name": "IPhone 17 Pro Max",
        "price": 1400,
        "quantity": 3
    },
    {
        "id": 2,
        "name": "Xiaomi Ultra Pro 5",
        "price": 960,
        "quantity": 8
    },
    {
        "id": 3,
        "name": "Samsung Galaxy Pro 7",
        "price": 1060,
        "quantity": 6
    },
    {
        "id": 4,
        "name": "IPhone 15",
        "price": 1000,
        "quantity": 12
    }
]
 */
