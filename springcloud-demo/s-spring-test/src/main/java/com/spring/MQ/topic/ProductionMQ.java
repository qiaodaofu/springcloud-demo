package com.spring.MQ.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  topic交换器   测试的时候最好把队列删除掉。
 *
 *  失败通知模式
 *  确认模式：同步：单条确认、批量确认
 *              异步：
 */
public class ProductionMQ {

    private final static String exchange="direct_name_topic";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("114.116.98.243");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC);
//        失败通知，消息没有发送到队列，只是用来监控路由键的
        channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> {
            String s = new String(body);
            System.out.println(replyText+"============");
        });
        connection.addShutdownListener(cause -> System.out.println("连接关闭时执行"+cause));
//        信道关闭的时候执行
        channel.addShutdownListener(cause -> System.out.println("信道关闭了"+cause));
//      开启确认模式
        channel.confirmSelect();

        String[] string = {"info","error","warning"};
        for (int i = 0; i < string.length; i++) {
            String[] service = {"order","user","vendor"};
            for (int j = 0; j < service.length; j++) {
                String[] abc = {"A","B","C"};
                for (int k = 0; k < abc.length; k++) {
                    String str = "["+string[i]+"."+service[j]+"."+abc[k]+"]";
                    String router = string[i]+"."+service[j]+"."+abc[k];
//                    这里启用了失败通知
                    channel.basicPublish(exchange,router,true,null,str.getBytes());
                    System.out.println(str);
//                    单条确认
//                    if (channel.waitForConfirms()) {
//                        System.out.println("发送成功");
//                    }else{
//                        System.out.println("发送失败");
//                    }
                }
            }
        }
//        批量确认
        channel.waitForConfirmsOrDie();
//        channel.close();
//        connection.close();
    }
}
