package com.gudf.community.dto;

import lombok.Data;

/**
 * @Author: CB#
 * @Date: 2019/7/16
 * @Description: com.gudf.community.dto
 * @version: 1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
