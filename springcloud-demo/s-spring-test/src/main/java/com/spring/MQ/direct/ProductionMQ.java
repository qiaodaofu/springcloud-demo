package com.spring.MQ.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  交换器持久化、队列持久化、消息持久化，队列持久化不等于消息持久化。
 *
 */
public class ProductionMQ {

    private final static String exchange="direct_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("114.116.98.243");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT,true,false,null);
        String[] msg = {"error","info","warning"};
        for (int i = 0; i < 1000; i++) {
            String str = "Hello world,"+i;
            try {
                channel.basicPublish(exchange,"error",MessageProperties.PERSISTENT_TEXT_PLAIN,str.getBytes());
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
