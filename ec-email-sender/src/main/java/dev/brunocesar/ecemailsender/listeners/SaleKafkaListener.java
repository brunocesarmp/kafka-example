package dev.brunocesar.ecemailsender.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import dev.brunocesar.ecemailsender.domains.Sale;

@Component
public class SaleKafkaListener {

	@KafkaListener(topics = "sale")
	public void getFromKafka(Sale sale) {
		System.out.println(sale);
	}

}
