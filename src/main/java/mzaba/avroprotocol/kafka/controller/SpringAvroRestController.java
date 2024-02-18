package mzaba.avroprotocol.kafka.controller;

import lombok.RequiredArgsConstructor;
import mzaba.avroprotocol.kafka.model.BookModel;
import mzaba.avroprotocol.kafka.producer.SpringAvroProducer;
import mzaba.avroprotocol.schema.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class SpringAvroRestController {

    private SpringAvroProducer springAvroProducer;

    @PostMapping(value = "/sendBook")
    public void sendBook(@RequestBody BookModel model){
        var book = Book.newBuilder().build();
        book.setTitle(model.getTitle());
        book.setAuthor(model.getAuthor());
        book.setPrice(model.getPrice());
        book.setId(new Random(1000).nextInt());
    }
}
