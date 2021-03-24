package dev.brunocesar.ecsale.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import dev.brunocesar.ecsale.domains.Sale;
import dev.brunocesar.ecsale.services.enums.KafkaProducerTopicsEnum;

@Service
public class KafkaProducerService {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final Gson jsonConverter;

	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
		this.kafkaTemplate = kafkaTemplate;
		this.jsonConverter = jsonConverter;
	}

	public void register(KafkaProducerTopicsEnum topic, Sale sale) {
		kafkaTemplate.send(topic.getValue(), jsonConverter.toJson(sale));
	}

}
