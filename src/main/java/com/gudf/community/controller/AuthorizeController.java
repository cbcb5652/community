package com.gudf.community.controller;

import com.gudf.community.dto.AccessTokenDTO;
import com.gudf.community.dto.GithubUser;
import com.gudf.community.mapper.UserMapper;
import com.gudf.community.model.User;
import com.gudf.community.provider.GithubProvider;
import com.gudf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: CB#
 * @Date: 2019/7/16
 * @Description: com.gudf.community.controller
 * @version: 1.0
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUrl;


    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response
                           ){
       AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
       accessTokenDTO.setClient_id(clientId);
       accessTokenDTO.setClient_secret(clientSecret);
       accessTokenDTO.setCode(code);
       accessTokenDTO.setRedirect_url(redirectUrl);
       accessTokenDTO.setState(state);
       String accessToken =  githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser!=null&&githubUser.getId()!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatar_url());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token",token));
            //登录成功，写cookie和session
//            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
