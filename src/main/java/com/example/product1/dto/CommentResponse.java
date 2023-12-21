package com.example.product1.dto;

import com.example.product1.entity.Client;
import com.example.product1.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CommentResponse {
    private int id;
    private String comment;
    private Client client;
    private Product product;
}
