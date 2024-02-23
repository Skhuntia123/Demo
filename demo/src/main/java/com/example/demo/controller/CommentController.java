package com.example.demo.controller;

import com.example.demo.Payload.CommentDTO;
import com.example.demo.Services.CommentService;
import com.example.demo.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/")
public class CommentController {


    @Autowired
    private CommentService commentservice;

    @PostMapping("{postId}/comments")
    public ResponseEntity<CommentDTO> saveComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        // Find the post with the given post ID


        // Save the comment
        CommentDTO dto = commentservice.save(postId, commentDTO);

        // Return the saved comment with a CREATED status code
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }
}










