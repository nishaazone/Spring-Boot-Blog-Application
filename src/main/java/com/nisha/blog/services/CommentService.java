package com.nisha.blog.services;

import com.nisha.blog.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);

    void deleteComment(Integer commentId);
}
