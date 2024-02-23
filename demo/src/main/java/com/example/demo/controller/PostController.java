package com.example.demo.controller;

import com.example.demo.Payload.PostDTO;
import com.example.demo.Services.PostService;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postservice; // assuming PostRepository interface is already defined

    // POST /api/posts
    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {

        PostDTO dto = postservice.save(postDTO);

        return new ResponseEntity(dto, HttpStatus.CREATED);
    }
}
