package com.magic.rabbitmq.pra.direct;

import com.alibaba.fastjson.JSON;
import com.magic.common.enums.RabbitMQEnum;
import com.magic.dto.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Producer
 * @date 2020/1/16 17:53
 */

@Slf4j
@Component
public class Producer extends AbstractProducer {


    public Producer(AmqpTemplate template) {
        super(template);
    }

    @Override
    public boolean send(User user) {
        try {
            String strUser = JSON.toJSONString(user);
            log.info("Direct生产者发送消息，user:{}",strUser);
            this.template.convertAndSend(RabbitMQEnum.DIRECT_QUEUE.getName(),strUser);
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e.toString());
            throw new RuntimeException();
        }
    }
}
