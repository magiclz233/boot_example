package com.magic.rabbitmq.pra.topic;

import com.alibaba.fastjson.JSON;
import com.magic.common.enums.RabbitMQEnum;
import com.magic.dto.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName TopicProducer
 * @date 2020/1/16 21:06
 */
@Component
public class TopicProducer {

    @Autowired
    AmqpTemplate template;

    public void send1(User user){
        String jsonUser = JSON.toJSONString(user);
        System.out.println("生产者1，绑定条件topic.msg,"+jsonUser);
        template.convertAndSend(RabbitMQEnum.TOPIC_EXCHANGE.getName(),"topic.msg",jsonUser);
    }

    public void send2(User user){
        String jsonUser = JSON.toJSONString(user);
        System.out.println("生产者2，绑定条件topic.msg.xxx,"+jsonUser);
        template.convertAndSend(RabbitMQEnum.TOPIC_EXCHANGE.getName(),"topic.msg.xxx",jsonUser);
    }

    public void send3(User user){
        String jsonUser = JSON.toJSONString(user);
        System.out.println("生产者3，绑定条件topic.msg.z,"+jsonUser);
        template.convertAndSend(RabbitMQEnum.TOPIC_EXCHANGE.getName(),"topic.msg.z",jsonUser);
    }

    public void send4(User user){
        String jsonUser = JSON.toJSONString(user);
        System.out.println("生产者4，绑定条件topic.msg.z.xxx,"+jsonUser);
        template.convertAndSend(RabbitMQEnum.TOPIC_EXCHANGE.getName(),"topic.msg.z.xxx",jsonUser);
    }
}
