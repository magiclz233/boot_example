package com.magic.rabbitmq.pra.topic;

import com.alibaba.fastjson.JSON;
import com.magic.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName TopicConsumer
 * @date 2020/1/16 21:11
 */

@Component
@RabbitListener(queues = "topic1")
public class TopicConsumer1 {

    @RabbitHandler
    public void receiver(String msg) {
        User user = JSON.parseObject(msg, User.class);
        System.out.println("消费者1,绑定topic1,topic1和交换机条件为topic.msg,"+user.toString());
    }
}
