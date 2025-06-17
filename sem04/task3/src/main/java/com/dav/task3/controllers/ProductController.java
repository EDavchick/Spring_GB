package com.dav.task3.controllers;

import com.dav.task3.models.Product;
import com.dav.task3.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products",
                productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        model.addAttribute("products",
                productService.getAllProducts());
        return "products";
    }
}
