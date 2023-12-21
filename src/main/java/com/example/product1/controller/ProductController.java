package com.example.product1.controller;

import com.example.product1.entity.Comment;
import com.example.product1.entity.Product;
import com.example.product1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private  ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        productService.update(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return productService.delete(id);
    }

    @GetMapping("/{productId}/comments")
    public List<Comment> getProductComments(@PathVariable int productId) {
        return productService.getProductComments(productId);
    }
}
