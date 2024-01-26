package com.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/10 19:51
 * @Description
 */
@Service
public class RedisService {

    @Resource
    StringRedisTemplate template;

    @PostConstruct
    public void init() {
        template.setEnableTransactionSupport(true);
    }

    @Transactional
    public void test() {
        template.multi();
        template.opsForValue().set("D", "ddd");
        template.exec();
    }
}
