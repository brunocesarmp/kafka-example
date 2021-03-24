package dev.brunocesar.ecsale.usecases;

import org.springframework.stereotype.Service;

import dev.brunocesar.ecsale.domains.Sale;
import dev.brunocesar.ecsale.services.KafkaProducerService;
import dev.brunocesar.ecsale.services.enums.KafkaProducerTopicsEnum;

@Service
public class ProcessSaleUseCase {

	private final KafkaProducerService kafkaProducerService;

	public ProcessSaleUseCase(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	public void execute(Sale sale) {
		// processment
		kafkaProducerService.register(KafkaProducerTopicsEnum.SALE, sale);
	}

}
