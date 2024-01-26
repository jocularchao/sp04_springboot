package com.example._03mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example._03mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/8 21:30
 * @Description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username};")
    User selectById(String username);
}
