package com.example.product1.service;

import com.example.product1.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(int id);
    Comment save(Comment comment);
    Comment delete(int id);
    public List<Comment> getProductComments(int productId);
}
