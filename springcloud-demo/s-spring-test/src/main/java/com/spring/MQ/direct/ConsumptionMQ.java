package com.spring.MQ.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 手动确认单条
 */
public class ConsumptionMQ{
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
//      声明队列
        String queueName="queueTest";
        channel.queueDeclare(queueName,true,false,false,null);
//        绑定
        String routerKey = "error";
        channel.queueBind(queueName,exchange,routerKey);
//        声明一个消费者

        final Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {

              try {
                  System.out.println(new String(body,"UTF-8"));
//                  单条确认。也可以尽心批量确认，就是等待发送过来多少消息时再确认。
                  channel.basicAck(envelope.getDeliveryTag(),false);
              }catch (Exception e){
//                  参数具体还需要查询百度
                  channel.basicNack(envelope.getDeliveryTag(),false,false);
              }
            }
        };
//       消费信息
        channel.basicConsume(queueName,false,consumer);
    }
}
