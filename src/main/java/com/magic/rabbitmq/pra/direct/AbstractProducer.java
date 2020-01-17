package com.magic.rabbitmq.pra.direct;

import com.magic.dto.User;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName AbstractProducer
 * @date 2020/1/16 17:58
 */
public abstract class AbstractProducer {

    final AmqpTemplate template;

    public AbstractProducer(AmqpTemplate template) {
        this.template = template;
    }

    abstract boolean send(User user);
}
