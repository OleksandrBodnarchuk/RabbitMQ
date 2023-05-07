package pl.alex.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.name())
                .surname(customerRequest.surname())
                .email(customerRequest.email())
                .build();

        customerRepository.saveAndFlush(customer);
        // TODO: check if email is valid
        // TODO: check if email is not taken
        // TODO: check if customer is fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());

        if(Objects.isNull(fraudCheckResponse)|| fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

    }
}
