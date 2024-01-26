package top.jocularchao._01template.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/7 18:24
 * @Description
 */
@Controller
public class IndexController {

    @Value("${test.data}")
    int data;

}
