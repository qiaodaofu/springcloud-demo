package com.spring.MQ.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumptionMQ{
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
//      声明队列
        String queueName="queueFanout";
        channel.queueDeclare(queueName,false,false,false,null);
//        绑定
        channel.queueBind(queueName,exchange,"");
//        声明一个消费者

        final Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println(new String(body,"UTF-8"));
            }
        };
//       消费信息
        channel.basicConsume(queueName,true,consumer);
    }
}
