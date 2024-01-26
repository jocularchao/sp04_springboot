package com.example;

import com.example.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/10 19:27
 * @Description
 */
@SpringBootTest
public class RedisTests {

    @Autowired
    StringRedisTemplate template;


    @Test
    public void setStr() {
        ValueOperations<String, String> operations = template.opsForValue();

        operations.set("test", "test");
        System.out.println(operations.get("test"));

    }

    @Test
    public void delStr() {

        template.delete("test");

        System.out.println(template.hasKey("test"));
    }



    @Test
    public void test() {
        new RedisService().test();
        System.out.println(template.opsForValue().get("D"));
    }

}
