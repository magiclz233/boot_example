package com.magic.rabbitmq.start;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Producer
 * @date 2020/1/16 15:28
 */
public class RbProducer {
    public static final String  EXCHANGE = "exchange1";
    public static final String  QUEUE_NAME = "queue1111";
    public static final String  ROUTING_KEY = "routingKey1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

//        channel.queueDeclare(QUEUE_NAME,true,true,true,null);

        String msg = "hello world";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes(StandardCharsets.UTF_8));
        System.out.println("send:"+msg);
        channel.close();
        connection.close();

    }
}
