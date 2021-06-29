import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class AvroProducer {

	public static void main(String[] args) throws Exception{
		
		String topicName = "AvroClicks";
		String msg;
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", "http://localhost:8081");
        
        Producer<String, ClickRecord> producer = new KafkaProducer<String, ClickRecord>(props);
        
        ClickRecord cr = new ClickRecord();
        
        try {
        	cr.setSessionId("10001");
        	cr.setChannel("Homepage");
        	cr.setIp("192.168.0.1");
        	
        	producer.send(new ProducerRecord<String, ClickRecord>(topicName, cr.getSessionId().toString(), cr)).get();
        	
        	System.out.println("Complete");
        	
        	
        } catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			producer.close();
		}

	}

}
