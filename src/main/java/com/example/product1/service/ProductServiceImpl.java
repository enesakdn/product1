package com.example.product1.service;

import com.example.product1.entity.Comment;
import com.example.product1.repository.ProductRepository;
import com.example.product1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        throw new RuntimeException("Id is not exist" + id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product delete(int id) {
        Product product = findById(id);
        productRepository.delete(product);
        return product;
    }
    @Override
    public void update(Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(updatedProduct.getId());

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPiece(updatedProduct.getPiece());
            productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Client with ID " + updatedProduct.getId() + " not found");
        }
    }

    @Override
    public List<Comment> getProductComments(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            return productOptional.get().getComments();
        } else {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
    }
}
