package concurrency.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Hello world!
 *
 */
public class CopyOfApp 
{
	public static String brokerURL = "tcp://localhost:61616";
    public static void main( String[] args )
    {
    	final ConnectionFactory cf = new ActiveMQConnectionFactory(brokerURL);
    	new Thread(new Runnable() {
			
			public void run() {
				sendMsg(cf);
			}
		}).start();
    }
    
    
	private static void sendMsg(ConnectionFactory cf) {
		try {
			Connection conn =  cf.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("test");
			MessageProducer producer = session.createProducer(destination);
			String msg = "Hello queue!";
			TextMessage message = session.createTextMessage(msg);
			
//			for(int i = 0; i < 100; i++){
				producer.send(destination, message);
//			}
				session.close();
				conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}


