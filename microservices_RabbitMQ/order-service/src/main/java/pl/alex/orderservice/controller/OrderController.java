package pl.alex.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.alex.orderservice.dto.Order;
import pl.alex.orderservice.dto.OrderEvent;
import pl.alex.orderservice.publisher.OrderProducer;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    private ResponseEntity<String> sendOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = OrderEvent.builder()
                .status("PENDING")
                .message("Order is pending")
                .order(order)
                .build();
        orderProducer.sendMessage(event);
        return ResponseEntity.ok("Order placed, status is: " + event.getStatus());
    }
}
