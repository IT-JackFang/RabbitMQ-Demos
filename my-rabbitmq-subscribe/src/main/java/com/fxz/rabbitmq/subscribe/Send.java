package com.fxz.rabbitmq.subscribe;

import com.fxz.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-24 15:21:38
 */
public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {

        // 获取连接，创建MQ通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机（exchange）
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息的内容
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();

    }


}
