package pl.alex.orderservice.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.alex.orderservice.dto.EmailEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProducer {

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    @Value("${rabbit.email.routing.key}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(EmailEvent emailEvent) {
        log.info("Order event sent to => {}", emailEvent.toString());
        rabbitTemplate.convertAndSend(exchangeName, emailRoutingKey, emailEvent);

    }

}
