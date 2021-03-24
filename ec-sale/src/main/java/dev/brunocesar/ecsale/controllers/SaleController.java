package dev.brunocesar.ecsale.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.brunocesar.ecsale.domains.Sale;
import dev.brunocesar.ecsale.usecases.ProcessSaleUseCase;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

	private final ProcessSaleUseCase processSaleUseCase;

	public SaleController(ProcessSaleUseCase processSaleUseCase) {
		this.processSaleUseCase = processSaleUseCase;
	}

	@PostMapping
	public ResponseEntity<?> process(@RequestBody Sale sale) {
		processSaleUseCase.execute(sale);
		return ResponseEntity.noContent().build();
	}

}
