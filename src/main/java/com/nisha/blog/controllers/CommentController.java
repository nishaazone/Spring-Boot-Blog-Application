package com.nisha.blog.controllers;

import com.nisha.blog.payloads.ApiResponse;
import com.nisha.blog.payloads.CommentDto;
import com.nisha.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("users/{userId}/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,  @PathVariable Integer userId, @PathVariable Integer postId){
        CommentDto createComment = this.commentService.createComment(comment, postId, userId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ApiResponse deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ApiResponse("Comment Deleted.", true);
    }

}
