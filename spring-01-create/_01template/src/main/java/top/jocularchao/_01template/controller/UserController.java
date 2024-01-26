package top.jocularchao._01template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jocularchao._01template.entity.User;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/7 13:13
 * @Description
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    @ResponseBody
    public User user() {
        User user = new User();

        user.setUsername("test");
        user.setPassword("123456");
        return user;
    }

}
