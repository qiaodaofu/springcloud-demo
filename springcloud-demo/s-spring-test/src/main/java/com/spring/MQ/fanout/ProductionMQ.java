package com.spring.MQ.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProductionMQ {

    private final static String exchange="direct_name_f";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("114.116.98.243");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT);
        for (int i = 0; i < 100; i++) {
            String str = "Hello world,"+i;
            try {
                channel.basicPublish(exchange,"error",null,str.getBytes());
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
