package dev.brunocesar.ecemailsender.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import dev.brunocesar.ecemailsender.domains.Sale;

@Component
public class SaleKafkaListener {

	private static final Logger LOG = LoggerFactory.getLogger(SaleKafkaListener.class);

	private final Gson jsonConverter;

	public SaleKafkaListener(Gson jsonConverter) {
		super();
		this.jsonConverter = jsonConverter;
	}

	@KafkaListener(topics = "sale")
	public void getFromKafka(String saleJson) {
		Sale sale = jsonConverter.fromJson(saleJson, Sale.class);
		LOG.info("Sending email to user {}, about sale {}", sale.getUser(), sale.getCode());
	}

}
