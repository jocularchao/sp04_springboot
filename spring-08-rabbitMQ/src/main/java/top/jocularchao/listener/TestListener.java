package top.jocularchao.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.jocularchao.entity.User;

/**
 * @author jocularchao
 * @date 2024-01-18 22:34
 * @description
 */
@Component
public class TestListener {

    //定义此方法为队列yyds的监听器，一旦监听到新的消息，就会接受并处理
    /*@RabbitListener(queues = "testqueue2")
    public void test(Message message){
        System.out.println(new String(message.getBody()));
    }*/

    /*@RabbitListener(queues = "testqueue2")
    public String receiver(String data){
        System.out.println("一号消息队列监听器 "+data);
        return "收到!";
    }*/

    @RabbitListener(queues = "testqueue2",messageConverter = "jsonMessageConverter")
    public void receiver(User user){
        System.out.println(user);
    }


}
