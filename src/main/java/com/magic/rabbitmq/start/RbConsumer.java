package com.magic.rabbitmq.start;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Consumer
 * @date 2020/1/16 15:29
 */
public class RbConsumer {
    public static final String  QUEUE_NAME = "queue1111";
    public static final String  EXCHANGE = "exchange1";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,true,true,true,null);
        DefaultConsumer consumer = new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("[Receive]：" + message);
            }

        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
