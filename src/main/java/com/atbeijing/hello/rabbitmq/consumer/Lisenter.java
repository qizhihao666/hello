package com.atbeijing.hello.rabbitmq.consumer;

import com.atbeijing.hello.rabbitmq.User;
import com.google.gson.Gson;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Lisenter {

    Gson gson = new Gson();

    @RabbitListener(queues = "TestDirectQueue")
    public void consumer(Message message, User user, Channel channel) throws Exception{
        //如果对象确定，可以直接用对象接收信息
        System.out.println(user);
        //message 可以用来获取请求消息头的相关信息

        MessageProperties messageProperties = message.getMessageProperties();
        //channel 可以对通道做一些设置，包括消息的确认机制等
//        channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
    }



}