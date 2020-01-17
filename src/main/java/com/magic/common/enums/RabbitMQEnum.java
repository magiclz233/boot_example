package com.magic.common.enums;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RabbitMQEnum
 * @date 2020/1/16 18:10
 */
public enum  RabbitMQEnum {

    DIRECT_QUEUE("directQueue"),
    ONE_QUEUE("oneQueue"),
    FANOUT_QUEUE_ONE("fanoutQueue1"),
    FANOUT_QUEUE_TWO("fanoutQueue2"),
    FANOUT_QUEUE_THREE("fanoutQueue3"),
    FANOUT_EXCHANGE("fanoutExchange"),
    TOPIC_QUEUE_ONE("topic1"),
    TOPIC_QUEUE_TWO("topic2"),
    TOPIC_QUEUE_THREE("topic3"),
    TOPIC_EXCHANGE("topicExchange");




    private String name;

    private RabbitMQEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
