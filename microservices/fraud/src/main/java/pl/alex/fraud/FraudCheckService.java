package pl.alex.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FraudCheckService {
	private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
	
	public boolean isFraudulentCustomer(Integer customerId) {
		fraudCheckHistoryRepository.save(
				FraudCheckHistory.builder()
				.isFraudster(false)
				.customerId(customerId)
				.createdAt(LocalDateTime.now())
				.build()
				);
		// TODO: can use other service to check
		return false;
	}
}
