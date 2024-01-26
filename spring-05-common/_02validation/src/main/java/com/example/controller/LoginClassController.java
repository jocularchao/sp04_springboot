package com.example.controller;

import com.example.entity.User;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 18:33
 * @Description
 */
@ControllerAdvice
@Controller
@Slf4j
@Validated
public class LoginClassController {

    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public String error(Exception e) {
        if (e instanceof ConstraintViolationException exception) {
            return exception.getMessage();
        }else if (e instanceof MethodArgumentNotValidException exception) {
            if (exception.getFieldError() == null)return "未知错误";
            return exception.getFieldError().getDefaultMessage();
        }
        return "未知错误";
    }

    @ResponseBody
    @PostMapping("/login1")
    public String login1(@Valid User user){
        System.out.println(user.getUsername().substring(3));
        System.out.println(user.getPassword().substring(2, 10));
        return "请求成功!";
    }
}
