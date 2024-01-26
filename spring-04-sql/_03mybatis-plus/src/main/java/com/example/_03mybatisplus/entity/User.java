package com.example._03mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/8 21:29
 * @Description
 */
@Data
@TableName("user")
public class User {

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;
}
