package com.spring.MQ.standby;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 *  使用备用交换器
 */
public class ProductionMQ {

    private final static String exchange="standby_direct_exchange";
    private final static String standby_exchange="ae";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("114.116.98.243");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
//        声明备用交换器
        Map<String,Object> map = new HashMap<>();
        map.put("alternate-exchange",standby_exchange);
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT,true,false,map);
//        定义备用交换器
        channel.exchangeDeclare(standby_exchange, BuiltinExchangeType.FANOUT,true,false,null);

        String[] msg = {"error","info","warning"};
        for (int i = 0; i < msg.length; i++) {
            String str = "Hello world,"+msg[i];
            try {
                channel.basicPublish(exchange,msg[i],null,str.getBytes());
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
