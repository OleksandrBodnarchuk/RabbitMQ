package pl.alex.orderservice.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.alex.orderservice.dto.EmailEvent;
import pl.alex.orderservice.dto.OrderEvent;
import pl.alex.orderservice.publisher.EmailProducer;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailProducer emailProducer;

    @PostMapping
    private ResponseEntity<String> sendOrder(@RequestBody EmailEvent email) {
        email.setId(UUID.randomUUID().toString());
        emailProducer.sendMessage(email);
        return ResponseEntity.ok("Email sent");
    }
}
