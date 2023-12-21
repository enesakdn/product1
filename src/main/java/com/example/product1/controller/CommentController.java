package com.example.product1.controller;

import com.example.product1.entity.Comment;
import com.example.product1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private  CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @DeleteMapping("/{id}")
    public Comment deleteComment(@PathVariable int id) {
        return commentService.delete(id);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }
}
