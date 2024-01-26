package top.jocularchao.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jocularchao.entity.User;
import top.jocularchao.mapper.UserMapper;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 17:13
 * @Description
 */
@Slf4j
@Controller
public class TestController {
    @Resource
    UserMapper mapper;

    @ResponseBody
    @GetMapping("/test")
    public User test(){
        log.info("用户访问了一次数据");
        return mapper.findUserByUsername("test");
    }
}
