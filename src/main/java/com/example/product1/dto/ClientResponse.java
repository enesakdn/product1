package com.example.product1.dto;

import com.example.product1.entity.Comment;
import com.example.product1.entity.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ClientResponse {

    private int id;
    private String name;
    private String surname;
    private List<Product> client_like_product;
    private List<Comment> comment;

}
