package com.atbeijing.hello.rabbitmq.testcontroller;

import com.atbeijing.hello.rabbitmq.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/requestDirect")
    public void testDirect(){
        System.out.println("come in");

        for(int i =0 ;i <= 0 ;i++){
            User user = User.builder().name("zhang3")
                    .age(i)
                    .phone(12346L)
                    .email("123@qq.com").build();
           new Thread(new myThread(user)).start();
        }

    }

    class  myThread implements Runnable{

        private User user;

        public myThread(User user){
            this.user = user;
        }

        @Override
        public void run() {
            rabbitTemplate.convertAndSend("TestDirectQueue",user);
            System.out.println("success ...");
        }
    }

}


