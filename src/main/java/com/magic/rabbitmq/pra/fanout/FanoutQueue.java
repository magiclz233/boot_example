package com.magic.rabbitmq.pra.fanout;

import com.magic.common.enums.RabbitMQEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName FanoutConfig
 * @date 2020/1/16 20:27
 */

@Configuration
public class FanoutQueue {

//    创建三个不同的队列

    @Bean
    public Queue fanoutQueue1(){
        return new Queue(RabbitMQEnum.FANOUT_QUEUE_ONE.getName());
    }

    @Bean
    public Queue fanoutQueue2(){
        return new Queue(RabbitMQEnum.FANOUT_QUEUE_TWO.getName());
    }

    @Bean
    public Queue fanoutQueue3(){
        return new Queue(RabbitMQEnum.FANOUT_QUEUE_THREE.getName());
    }

    /**
     * 创建交换机
     * @return 交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(RabbitMQEnum.FANOUT_EXCHANGE.getName());
    }

//    将三个队列与fanoutExchange交换机绑定

    @Bean
    public Binding bindingFanout1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingFanout2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
    @Bean
    public Binding bindingFanout3(){
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }

}
