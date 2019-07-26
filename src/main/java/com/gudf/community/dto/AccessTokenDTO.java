package com.gudf.community.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: CB#
 * @Date: 2019/7/16
 * @Description: com.gudf.community.dto
 * @version: 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;


}
