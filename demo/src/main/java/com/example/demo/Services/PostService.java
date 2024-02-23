package com.example.demo.Services;

import com.example.demo.Payload.PostDTO;
import com.example.demo.entities.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository; // assuming PostRepository interface is already defined

    public PostDTO save(PostDTO postDTO) {
        // convert PostDTO to Post entity
        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setTitle(postDTO.getTitle());

        // save post entity
        Post newpost = postRepository.save(post);

        // convert saved post entity to PostDTO and return
        PostDTO dto= new PostDTO();
        dto.setContent(newpost.getContent());
        dto.setDescription(newpost.getDescription());
        dto.setTitle(newpost.getTitle());
        dto.setPostId(newpost.getPostId());
        return dto;
    }
}
