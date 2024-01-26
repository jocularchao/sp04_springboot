package com.example._02jpa;

import com.example._02jpa.entity.User;
import com.example._02jpa.repository.UserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Resource
    UserRepository repository;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("test6");
        user.setPassword("1234567");
        System.out.println(repository.save(user).getUsername());   //使用save来快速插入数据，并且会返回插入的对象，如果存在自增ID，对象的自增id属性会自动被赋值，这就很方便了
    }

    @Test
    void queryByUsername() {
        repository.findById(1).ifPresent(System.out::println);
    }


}
