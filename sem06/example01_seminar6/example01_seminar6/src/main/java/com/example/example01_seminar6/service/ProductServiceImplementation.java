package com.example.example01_seminar6.service;

import com.example.example01_seminar6.model.Product;
import com.example.example01_seminar6.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService{
    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).
                orElseThrow(()->
                new NoSuchElementException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(Product product) {
        Product productById = getProductById(product.getId());

        productById.setPrice(product.getPrice());
        productById.setName(product.getName());
        productById.setQuantity(product.getQuantity());

        return productRepository.save(productById);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product productById = getProductById(id);
        productRepository.delete(productById);
    }
}
