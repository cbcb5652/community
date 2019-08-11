package com.gudf.community.dto;

import lombok.Data;

@Data
public class CommenCreatetDTO {

    private Long parentId;
    private String content;
    private Integer type;
}
