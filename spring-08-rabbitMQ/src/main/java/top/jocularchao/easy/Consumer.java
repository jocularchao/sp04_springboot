package top.jocularchao.easy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jocularchao
 * @date 2024-01-18 19:05
 * @description 消费者
 *
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //使用ConnectionFactory来创建连接
        ConnectionFactory factory = new ConnectionFactory();

        //设置信息
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/test");

        //这里不使用try-with-resource，因为消费者是一直等待新的消息到来，然后按照
        //我们设定的逻辑进行处理，所以这里不能在定义完成之后就关闭连接
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //创建一个基本的消费者
        channel.basicConsume("testqueue2", false, (s, delivery) -> {
            System.out.println(new String(delivery.getBody()));
            //basicAck是确认应答，第一个参数是当前的消息标签，后面的参数是
            //是否批量处理消息队列中所有的消息，如果为false表示只处理当前消息
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            //basicNack是拒绝应答，最后一个参数表示是否将当前消息放回队列，如果
            //为false，那么消息就会被丢弃
            //channel.basicNack(delivery.getEnvelope().getDeliveryTag(), false, false);
            //跟上面一样，最后一个参数为false，只不过这里省了
            //channel.basicReject(delivery.getEnvelope().getDeliveryTag(), false);
        }, s -> {});

    }

}
