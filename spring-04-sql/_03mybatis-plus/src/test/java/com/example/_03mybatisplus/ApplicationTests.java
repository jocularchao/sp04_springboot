package com.example._03mybatisplus;

import com.example._03mybatisplus.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Resource
    UserMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    void getUser() {
        System.out.println(mapper.selectById("test"));
    }

}
