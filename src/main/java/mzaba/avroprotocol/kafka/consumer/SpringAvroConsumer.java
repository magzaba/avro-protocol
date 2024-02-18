package mzaba.avroprotocol.kafka.consumer;

import mzaba.avroprotocol.schema.Book;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpringAvroConsumer {

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<String, Book> record){
        var key = record.key();
        var book = record.value();
        System.out.println("Avro message received for key: " + key + ", value: " + book.toString());
    }
}
