package com.magic;

import com.magic.dto.User;
import com.magic.rabbitmq.pra.direct.Producer;
import com.magic.rabbitmq.pra.fanout.FanoutProducer;
import com.magic.rabbitmq.pra.topic.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RabbitMqTest
 * @date 2020/1/16 20:10
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private Producer producer;

    @Autowired
    private FanoutProducer fanoutProducer;

    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void direct(){
        User user = new User(1,"magic","1997-08-21","男","西安");
        producer.send(user);
    }

    @Test
    public void fanout(){
        User user = new User(1,"magic","1997-08-21","男","西安");
        fanoutProducer.send(user);
    }

    @Test
    public void topic(){
        User user = new User(1,"magic","1997-08-21","男","西安");
        topicProducer.send1(user);
        topicProducer.send2(user);
        topicProducer.send3(user);
        topicProducer.send4(user);
    }
}
