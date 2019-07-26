package com.gudf.community.provider;

import com.alibaba.fastjson.JSON;
import com.gudf.community.dto.AccessTokenDTO;
import com.gudf.community.dto.GithubUser;
import okhttp3.*;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: CB#
 * @Date: 2019/7/16
 * @Description: com.gudf.community.provider
 * @version: 1.0
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
               String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        System.out.println("accessToken"+accessToken);
       Request request = new Request.Builder()
               .url("https://api.github.com/user?access_token="+accessToken)
               .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
