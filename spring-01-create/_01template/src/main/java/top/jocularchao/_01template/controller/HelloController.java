package top.jocularchao._01template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/10/26 23:55
 * @Description
 */

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/home")
    public String hello() {
        return "home";
    }


}
