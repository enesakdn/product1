package com.example.product1.service;

import com.example.product1.entity.Comment;
import com.example.product1.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    Product delete(int id);
    void update(Product updatedProduct);
    List<Comment> getProductComments(int productId);


}
