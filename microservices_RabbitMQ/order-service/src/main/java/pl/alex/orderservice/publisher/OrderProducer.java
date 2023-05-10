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

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    @Value("${rabbit.stock.routing.key}")
    private String orderRoutingKey;

    @Value("${rabbit.email.routing.key}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderEvent orderEvent) {
        log.info("Order event sent to => {}", orderEvent.toString());
        rabbitTemplate.convertAndSend(exchangeName, orderRoutingKey, orderEvent);
        log.info("Email event sent to => {}", "EmailService");
        rabbitTemplate.convertAndSend(exchangeName, emailRoutingKey, orderEvent);

    }

}
