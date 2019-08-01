package com.gudf.community.mapper;

import com.gudf.community.model.Question;
import org.springframework.stereotype.Component;

@Component
public interface QuestionExtMapper {
    int incView(Question record);
}
