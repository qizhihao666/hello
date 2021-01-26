package com.atbeijing.hello.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {


    @Bean
    public Queue topicQueue(){
        return new Queue("topicQueue",true,false,false);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topicQueue2",true,false,false);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange",true,false);
    }


    @Bean
    public Binding binding() {
      return  BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topicRoute");
    }

    @Bean
    public Binding binding2() {
        return  BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topicRoute2");
    }


}
