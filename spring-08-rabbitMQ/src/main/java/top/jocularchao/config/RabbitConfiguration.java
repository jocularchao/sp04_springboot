package top.jocularchao.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jocularchao
 * @date 2024-01-18 19:45
 * @description rabbit 配置类
 */
@Configuration
public class RabbitConfiguration {

    //定义交换机
    @Bean("directExchange")
    public Exchange exchange(){
        return ExchangeBuilder.directExchange("amq.direct").build();
    }

    //定义消息队列
    @Bean("testQueue")
    public Queue queue(){
        return QueueBuilder
                .nonDurable("testqueue2")   //非持久化类型
                .build();
    }

    //配置绑定方法
    @Bean("binding")
    public Binding binding(@Qualifier("directExchange") Exchange exchange,
                           @Qualifier("testQueue") Queue queue){
        //将刚刚配置的交换机和消息队列绑定
        return BindingBuilder
                .bind(queue)    //绑定队列
                .to(exchange)   //到交换机
                .with("test3-key")  //自定义的routingKey
                .noargs();
    }

    @Bean
    public Jackson2JsonMessageConverter  jsonMessageConverter() {    //直接创建一个用于JSON转换的Bean
        return new Jackson2JsonMessageConverter();
    }

    //创建死信队列和私信交换机
    @Bean("directDlExchange")
    public Exchange dlExchange(){
        return ExchangeBuilder.directExchange("dlx.direct").build();
    }



    @Bean("testDlQueue")
    public Queue dlQueue(){
        return QueueBuilder
                .nonDurable("dl-testqueue2")   //非持久化类型
                .build();
    }

    @Bean("dlBind")
    public Binding dlBinding(@Qualifier("directDlExchange") Exchange dlExchange,
                           @Qualifier("testDlQueue") Queue dlQueue){
        return BindingBuilder
                .bind(dlQueue)
                .to(dlExchange)
                .with("dl-key")
                .noargs();
    }



}
