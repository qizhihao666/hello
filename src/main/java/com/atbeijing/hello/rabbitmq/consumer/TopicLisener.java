package com.atbeijing.hello.rabbitmq.consumer;

import com.atbeijing.hello.rabbitmq.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicLisener {

     @RabbitListener(queues = "topicQueue")
    public void testTopic(User user){
         log.info("user==》"+user);
     }

    @RabbitListener(queues = "topicQueue2")
    public void testTopic2(User user){
        log.info("user2==》"+user);
    }

}
