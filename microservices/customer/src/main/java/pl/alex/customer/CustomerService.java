package pl.alex.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.name())
                .surname(customerRequest.surname())
                .email(customerRequest.email())
                .build();

        // TODO: check if email is valid
        // TODO: check if email is not taken
        // TODO: store customer in db
    }
}
