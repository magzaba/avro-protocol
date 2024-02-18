package mzaba.avroprotocol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AvroProtocolApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroProtocolApplication.class, args);
	}

}
