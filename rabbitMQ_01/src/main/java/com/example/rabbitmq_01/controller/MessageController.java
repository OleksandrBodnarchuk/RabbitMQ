package com.example.rabbitmq_01.controller;

import com.example.rabbitmq_01.dto.UserRecord;
import com.example.rabbitmq_01.publisher.RabbitMqJsonProducer;
import com.example.rabbitmq_01.publisher.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMqProducer rabbitMqProducer;
    private final RabbitMqJsonProducer rabbitMqJsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ!");
    }

    @PostMapping("/sendJson")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserRecord userRecord) {
        rabbitMqJsonProducer.sendJsonMessage(userRecord);
        return ResponseEntity.ok("JSON Message sent to RabbitMQ!");
    }

}
