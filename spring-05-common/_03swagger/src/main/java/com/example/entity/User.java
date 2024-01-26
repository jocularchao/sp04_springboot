package com.example.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 20:18
 * @Description
 */
@Data
public class User {
    @Schema(description = "用户名",example = "test")
    String username;

    @Schema(description = "密码",example = "123456")
    String password;


}
