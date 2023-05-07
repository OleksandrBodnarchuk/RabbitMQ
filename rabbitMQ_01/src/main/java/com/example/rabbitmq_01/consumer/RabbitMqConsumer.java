package com.example.rabbitmq_01.consumer;

import com.example.rabbitmq_01.dto.UserRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMqConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.string.name}"})
    public void consume(String message){
        log.info("[MESSAGE RECEIVED] -> {}", message);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJson(UserRecord dto){
        log.info("[JSON MESSAGE RECEIVED] -> {}", dto);
    }

}
