package com.magic.rabbitmq.pra.direct;

import com.alibaba.fastjson.JSON;
import com.magic.common.enums.RabbitMQEnum;
import com.magic.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Consumer
 * @date 2020/1/16 18:20
 */
@Component
@RabbitListener(queues = "directQueue")
public class Consumer {

    @RabbitHandler
    public void receive(String context){
        User user = JSON.parseObject(context, User.class);
        System.out.println("消费者："+user.getUserName()+"~~"+user.getSex()+"~~~"+user.getSex());
    }

}
