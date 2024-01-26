package com.example.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 20:16
 * @Description
 */
@Controller
@Slf4j
@Hidden     //忽略 swagger展示
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String str) {
        return str;
    }


}
