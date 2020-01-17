package com.magic.rabbitmq.pra.fanout;

import com.alibaba.fastjson.JSON;
import com.magic.common.enums.RabbitMQEnum;
import com.magic.dto.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName FanoutProducer
 * @date 2020/1/16 20:40
 */

@Component
public class FanoutProducer {

    @Autowired
    private AmqpTemplate template;


    public void send(User user){
        String json = JSON.toJSONString(user);
        System.out.println("生产者"+json);
        /*
        第一个是生产者绑定的交换机
        第二个参数是匹配模式，
        第三个是消息本体
         */
        template.convertAndSend(RabbitMQEnum.FANOUT_EXCHANGE.getName(),"",json);
    }


}
