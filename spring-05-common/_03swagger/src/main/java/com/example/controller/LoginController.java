package com.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 19:59
 * @Description
 */
@Controller
@Tag(name = "登录",description = "登陆验证")
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "测试成功"),
            @ApiResponse(responseCode = "500",description = "测试失败")
    })
    @Operation(summary = "用户登录接口")
    public String login( String username, String password) {
        return username+" "+password;
    }
}
