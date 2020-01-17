package com.magic.rabbitmq.pra.topic;

import com.magic.common.enums.RabbitMQEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName TopicQueue
 * @date 2020/1/16 20:57
 */
@Configuration
public class TopicQueue {

    @Bean
    public Queue topicQueue1() {
        return new Queue(RabbitMQEnum.TOPIC_QUEUE_ONE.getName());
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(RabbitMQEnum.TOPIC_QUEUE_TWO.getName());
    }

    @Bean
    public Queue topicQueue3() {
        return new Queue(RabbitMQEnum.TOPIC_QUEUE_THREE.getName());
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(RabbitMQEnum.TOPIC_EXCHANGE.getName());
    }
/*
    #代表多个*代表一个
    根据规则绑定交换机和队列，发送者发送时第二个参数满足哪个队列规则，
    哪个队列就会接收到消息，这样绑定这个队列的消费者就会接收到发送过来的消息
 */

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(topicQueue1())
                .to(topicExchange()).with("topic.msg");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(topicQueue2())
                .to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(topicQueue3())
                .to(topicExchange()).with("topic.*.z");
    }

}
