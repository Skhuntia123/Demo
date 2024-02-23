package com.example.demo.Services;

import com.example.demo.Payload.CommentDTO;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    public CommentDTO save(Long postId, CommentDTO commentDTO) {
        // Find the post with the given post ID
        Post post = postRepository.findById(postId).get();

        Comment comment = new Comment();
        comment.setCommentId(commentDTO.getCommentId());
        comment.setBody(commentDTO.getBody());
        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setPost(post);

        // Save the comment
        Comment newcomment = commentRepository.save(comment);

        CommentDTO dto = new CommentDTO();

        dto.setCommentId(newcomment.getCommentId());
        dto.setBody(newcomment.getBody());
        dto.setName(newcomment.getName());
        dto.setEmail(newcomment.getEmail());

        return dto;
    }
}
