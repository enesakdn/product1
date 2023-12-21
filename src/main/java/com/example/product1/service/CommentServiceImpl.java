package com.example.product1.service;

import com.example.product1.repository.CommentRepository;
import com.example.product1.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
@Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
        }
        throw new RuntimeException("Id is not exist" + id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment delete(int id) {
        Comment comment = findById(id);
        commentRepository.delete(comment);
        return comment;
    }
    @Override
    public List<Comment> getProductComments(int productId) {
        return commentRepository.findByProductId(productId);
    }
}
