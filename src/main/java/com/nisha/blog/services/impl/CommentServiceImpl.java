package com.nisha.blog.services.impl;

import com.nisha.blog.entities.Comment;
import com.nisha.blog.entities.Post;
import com.nisha.blog.entities.User;
import com.nisha.blog.exceptions.ResourceNotFoundException;
import com.nisha.blog.payloads.CommentDto;
import com.nisha.blog.repositories.CommentRepo;
import com.nisha.blog.repositories.PostRepo;
import com.nisha.blog.repositories.UserRepo;
import com.nisha.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        comment.setUser(user);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);

    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment com = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId ));
        this.commentRepo.delete(com);
    }
}
