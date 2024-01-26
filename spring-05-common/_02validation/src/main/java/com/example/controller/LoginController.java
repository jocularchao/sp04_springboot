package com.example.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 18:15
 * @Description
 */
@Controller
@Validated  //首先在Controller上开启接口校验
@Slf4j
@ControllerAdvice
public class LoginController {

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public String error(ValidationException e) {
        return e.getMessage();  //异常就直接返回消息
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@Length(min = 3) String username,  //使用@Length注解一步到位
                         @Length(min = 10) String password){
        System.out.println(username.substring(3));
        System.out.println(password.substring(2, 10));
        return "请求成功!";
    }



}
