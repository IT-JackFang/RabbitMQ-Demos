package com.fxz.rabbitmq.work;

import com.fxz.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-24 14:30:11
 */
public class Send {

    private static final String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // 获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 100; i++) {
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }




    }


}
