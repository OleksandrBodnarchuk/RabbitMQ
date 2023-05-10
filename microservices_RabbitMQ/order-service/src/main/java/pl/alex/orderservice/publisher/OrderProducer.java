package pl.alex.orderservice.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.alex.orderservice.dto.OrderEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {

    @Value("${rabbit.order.exchange.name}")
    private String orderExchange;

    @Value("${rabbit.order.routing.key}")
    private String orderRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderEvent orderEvent) {
        log.info("Order event sent to => {}", orderEvent.toString());
        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey, orderEvent);

    }

}
