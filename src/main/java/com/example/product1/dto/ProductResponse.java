package com.example.product1.dto;

import com.example.product1.entity.Client;
import com.example.product1.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private int id;
    private String name;
    private int piece;
    private List<Client> like_client;
    private List<Comment> comments;
}
