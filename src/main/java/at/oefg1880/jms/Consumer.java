package at.oefg1880.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by IntelliJ IDEA.
 * User: AT003053
 * Date: 26.09.12
 * Time: 09:43
 * To change this template use File | Settings | File Templates.
 */
public class Consumer {
    private static String defaultUrl = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "TESTTOOL";

    public static void main(String[] args) throws JMSException {
        // get a JMS Connection and start it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(defaultUrl);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // JMS Messages are sent and received using sessions
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a queue for the destination of the messages on the JMS Server
        Destination destination = session.createQueue(subject);

        // Create a MessageConsumer to receive a message from the JMS Server
        MessageConsumer consumer = session.createConsumer(destination);

        // Receive (consume) a message from the JMS Server,
        // this call is blocking, so it waits until it gets a message
        Message message = consumer.receive();

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Message received: " + textMessage.getText());
        }

        connection.close();
    }

}
