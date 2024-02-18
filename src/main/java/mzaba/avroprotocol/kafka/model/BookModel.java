package mzaba.avroprotocol.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModel {
    private int id;
    private String title;
    private String author;
    private float price;
    private int pages;
}
