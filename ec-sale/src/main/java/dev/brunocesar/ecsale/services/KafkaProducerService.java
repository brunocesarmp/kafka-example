package dev.brunocesar.ecsale.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import dev.brunocesar.ecsale.domains.Sale;
import dev.brunocesar.ecsale.services.enums.KafkaProducerTopicsEnum;

@Service
public class KafkaProducerService {

	private final KafkaTemplate<String, Sale> kafkaTemplate;

	public KafkaProducerService(KafkaTemplate<String, Sale> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void register(KafkaProducerTopicsEnum topic, Sale sale) {
		kafkaTemplate.send(topic.getValue(), sale);
	}

}
