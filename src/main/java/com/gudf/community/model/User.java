package com.gudf.community.model;

import lombok.Data;

/**
 * @Author: CB#
 * @Date: 2019/7/18
 * @Description: com.gudf.community.model
 * @version: 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long  gmt_create;
    private Long gmt_modified;
    private String avatarUrl;
}
