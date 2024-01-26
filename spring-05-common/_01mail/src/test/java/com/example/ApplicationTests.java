package com.example;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class ApplicationTests {

    @Autowired
    JavaMailSender sender;

    @Test
    void contextLoads() {
        //SimpleMailMessage是一个比较简易的邮件封装，支持设置一些比较简单内容
        SimpleMailMessage message = new SimpleMailMessage();
        //标题
        message.setSubject("清华大学办事处  关于近期学校对您的处分决定");
        //内容
        message.setText("开除");
        //设置邮箱发给谁
        message.setTo("jocularchao@gmail.com");
        //邮件发送者
        message.setFrom("jocularchao@163.com");
        //ok
        sender.send(message);
    }


    @Test
    void contextLoads1() throws MessagingException {
        //创建一个MimeMessage
        MimeMessage message = sender.createMimeMessage();
        //使用MimeMessageHelper来帮我们修改MimeMessage中的信息
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Test");
        helper.setText("lbwnb");
        helper.setTo("jocularchao@gmail.com");
        helper.setFrom("jocularchao@163.com");
        //发送修改好的MimeMessage
        sender.send(message);
    }
}
