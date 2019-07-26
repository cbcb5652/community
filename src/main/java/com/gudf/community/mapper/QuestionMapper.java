package com.gudf.community.mapper;

import com.gudf.community.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Author 晨边#CB
 * @Description 受理界面
 * @Date  2019/7/21
 **/

@Mapper
@Component
public interface QuestionMapper {

    @Insert("insert into question (title ,description,gmt_create ,gmt_modified,creator,tag) value (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
     void create(Question question);

    @Select("select * from question limit #{offset} ,#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId")Integer userId);

    @Select("select * from question where id = #{id} ")
    Question getById(@Param("id")Integer id);

    @Update("update question set title = #{title} ,description = #{description}, gmt_modified = #{gmtModified},tag = #{tag} where id = #{id}")
    void update(Question question);
}
