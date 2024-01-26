package top.jocularchao.easy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jocularchao
 * @date 2024-01-18 19:05
 * @description 生产者
 */
public class Producer {

    public static void main(String[] args) {
        //使用ConnectionFactory来创建连接
        ConnectionFactory factory = new ConnectionFactory();

        //设置信息
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/test");

        //创建连接
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();){//通过connection创建通道
            //直接在程序中定义并创建消息队列
            channel.queueDeclare("testqueue2",false,false,false,null);
            //将队列绑定到交换机
            channel.queueBind("testqueue2","amq.direct","test2-key");
            //发送消息
            channel.basicPublish("amq.direct", "test2-key", null, "3Hello World!".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
