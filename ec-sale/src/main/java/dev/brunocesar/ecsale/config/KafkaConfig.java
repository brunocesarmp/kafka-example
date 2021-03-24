package dev.brunocesar.ecsale.config;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import dev.brunocesar.ecsale.domains.Sale;

@EnableKafka
@Configuration
public class KafkaConfig {

	@Bean
	public ProducerFactory<String, Sale> producerFactory() {
		HashMap<String, Object> configs = new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(configs);
	}

	@Bean
	KafkaTemplate<String, Sale> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
