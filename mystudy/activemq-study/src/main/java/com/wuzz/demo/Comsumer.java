package com.wuzz.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Create with IntelliJ IDEA
 * User: Wuzhenzhao
 * Date: 2019/5/5
 * Time: 16:51
 * Description 描述:
 */
public class Comsumer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.1.101:61616");
        Connection connection = null;
        try {

            connection = connectionFactory.createConnection();
            connection.start();
            // 延迟确认
            Session session = connection.createSession(Boolean.TRUE, Session.DUPS_OK_ACKNOWLEDGE);
            // 创建目的地
            Destination destination = session.createQueue("myQueue");
            // 创建消费者
            MessageConsumer consumer = session.createConsumer(destination);
            TextMessage textMessage = (TextMessage) consumer.receive();
            System.out.println(textMessage.getText());
            // 表示消息被自动确认
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
