package com.magic.rabbitmq.start;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RabbitConnectionUtil
 * @date 2020/1/17 11:02
 */
@Slf4j
public class RabbitConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        Connection connection = null;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("106.75.216.194");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        connection = factory.newConnection();
        return connection;
    }
}
