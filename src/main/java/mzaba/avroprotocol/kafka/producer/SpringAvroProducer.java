package mzaba.avroprotocol.kafka.producer;

import lombok.RequiredArgsConstructor;
import mzaba.avroprotocol.schema.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class SpringAvroProducer {

    @Value("${avro.topic.name}")
    String topicName;
    private KafkaTemplate<String, Book> kafkaTemplate;

    public void send(Book book){
        ListenableFuture <SendResult<String,Book>> future =  kafkaTemplate.send(topicName, String.valueOf(book.getId()), book);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.err.println("Message failed to produce.");
            }

            @Override
            public void onSuccess(SendResult<String, Book> result) {
                System.out.println("Message successfully produced.");
            }
        });
    }
}
