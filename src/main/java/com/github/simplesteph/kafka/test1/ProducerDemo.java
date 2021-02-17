package com.github.simplesteph.kafka.test1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {

        // Creating the ProducerProperties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Creating the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


        String topic = "first_topic";
        String value = "HelloWorld";

        // Creating a Producer record
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>(topic, value);
        // Sending the data
        producer.send(record);

        // flushing data
        producer.flush();

        // flushing and closing the producer
        producer.close();

    }
}
