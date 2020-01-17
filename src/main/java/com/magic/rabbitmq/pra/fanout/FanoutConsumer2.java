package com.magic.rabbitmq.pra.fanout;

import com.alibaba.fastjson.JSON;
import com.magic.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName FanoutConsumer
 * @date 2020/1/16 20:45
 */

@Component
@RabbitListener(queues = "fanoutQueue2")
public class FanoutConsumer2 {

    @RabbitHandler
    public void receiver(String msg){
        User user = JSON.parseObject(msg, User.class);
        System.out.println("消费者"+user.toString()+"2");
    }
}
