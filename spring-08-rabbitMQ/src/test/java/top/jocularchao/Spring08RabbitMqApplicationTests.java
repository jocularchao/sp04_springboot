package top.jocularchao;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import top.jocularchao.entity.User;

@SpringBootTest
class Spring08RabbitMqApplicationTests {

    //RabbitTemplate为我们封装了大量的RabbitMQ操作，已经由Starter提供，因此直接注入使用即可
    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void publisher(){
        //使用convertAndSend方法一步到位，参数基本和之前是一样的
        //最后一个消息本体可以是Object类型，真是大大的方便
        //rabbitTemplate.convertAndSend("amq.direct","test3-key","aaaa");
        Object res = rabbitTemplate.convertSendAndReceive("amq.direct", "test3-key", "aaaa");
        System.out.println("收到消费者响应"+res);
    }

    @Test
    void publisher1() {
        rabbitTemplate.convertAndSend("amq.direct", "test3-key", new User());
    }



}
