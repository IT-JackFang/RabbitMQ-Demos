package com.fxz.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-24 09:28:33
 */
public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        // 定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置主机、端口、虚拟主机、用户名和密码
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("testhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;

    }

}
