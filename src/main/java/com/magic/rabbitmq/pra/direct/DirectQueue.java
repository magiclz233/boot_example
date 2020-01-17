package com.magic.rabbitmq.pra.direct;

import com.magic.common.enums.RabbitMQEnum;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName DirectConfig
 * @date 2020/1/16 17:51
 */
@Configuration
public class DirectQueue {

    @Bean
    Queue directTestQueue(){
        return new Queue(RabbitMQEnum.DIRECT_QUEUE.getName());
    }

    @Bean
    Queue oneQueue(){
        return new Queue(RabbitMQEnum.ONE_QUEUE.getName());
    }
}
