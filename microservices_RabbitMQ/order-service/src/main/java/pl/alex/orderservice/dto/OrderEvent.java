package pl.alex.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private String status; // PENDING, PROGRESS, COMPLETED
    private String message;
    private OrderDto order;

}
