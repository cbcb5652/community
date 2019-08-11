package com.gudf.community.mapper;

import com.gudf.community.model.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}