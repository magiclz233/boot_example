package com.magic.rabbitmq.pra.fanout;

import com.alibaba.fastjson.JSON;
import com.magic.common.enums.RabbitMQEnum;
import com.magic.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.ref.SoftReference;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName FanoutConsumer
 * @date 2020/1/16 20:45
 */

@Component
@RabbitListener(queues = "fanoutQueue1")
public class FanoutConsumer1 {

    @RabbitHandler
    public void receiver(String msg){
        User user = JSON.parseObject(msg, User.class);
        System.out.println("消费者"+user.toString()+"1");

    }
}
