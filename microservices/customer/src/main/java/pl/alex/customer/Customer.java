package pl.alex.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer id;
    private String name;
    private String surname;
    private String email;
}
