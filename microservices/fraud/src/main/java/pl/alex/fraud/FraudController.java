package pl.alex.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController 
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

	private final FraudCheckService fraudCheckService; 
	
	@GetMapping("/{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
		log.info("Fraud check request for customer {}", customerId);
		return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
	}
}
