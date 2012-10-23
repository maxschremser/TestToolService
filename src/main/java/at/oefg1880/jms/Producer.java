package at.oefg1880.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import javax.jms.*;

/**
 * Created by IntelliJ IDEA.
 * User: AT003053
 * Date: 25.09.12
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class Producer {
    private static Logger log = Logger.getLogger(Producer.class);
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

        // Create a MessageProducer to send a message to the JMS Server
        MessageProducer producer = session.createProducer(destination);

        // Send a Hello World TextMessage
        String sMessage = args != null && args.length > 0 ? args[0] : "Hello World";
        TextMessage message = session.createTextMessage(sMessage);

        // Send the message
        producer.send(message);
        
        log.debug("Message sent: " + message.getText());

        connection.close();
    }
}
