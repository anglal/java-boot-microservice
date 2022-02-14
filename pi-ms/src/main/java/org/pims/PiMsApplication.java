package org.pims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class PiMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PiMsApplication.class, args);
	}

}
