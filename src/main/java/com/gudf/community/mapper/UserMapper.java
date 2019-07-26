package com.gudf.community.mapper;

import com.gudf.community.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @Author: CB#
 * @Date: 2019/7/18
 * @Description: com.gudf.community.mapper
 * @version: 1.0
 */
@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name}, #{account_id},#{token},#{gmt_create},#{gmt_modified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id")Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String account_id);

    @Update("update user set name = #{name},token = #{token}, gmt_modified= #{gmt_modified},avatar_url =#{avatarUrl} where id=#{id}")
    void update(User user);
}
