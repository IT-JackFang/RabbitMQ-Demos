package com.fxz.rabbitmq.simple;

import com.fxz.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-24 09:34:47
 */
public class Sender {

    private static final String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception{
        // 获取连接
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明或者创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消息内容
        String message = "Hello World!";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();

    }

}
