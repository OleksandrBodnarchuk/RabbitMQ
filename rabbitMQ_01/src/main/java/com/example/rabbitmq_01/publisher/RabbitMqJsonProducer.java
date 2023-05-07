package com.example.rabbitmq_01.publisher;


import com.example.rabbitmq_01.dto.UserRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routingKey.json.value}")
    private String jsonKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(UserRecord userRecord) {
        rabbitTemplate.convertAndSend(exchange, jsonKey, userRecord);
        log.info("[JSON message sent] -> {}", userRecord);
    }

}
