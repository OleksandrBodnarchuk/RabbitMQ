package pl.alex.emailservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailConsumer {

    @RabbitListener(queues = "${rabbit.email.queue.name}")
    public void consume(EmailEvent event) {
        log.info("EmailEvent received: {}", event.toString());
        // save to database or do some business logic etc.

    }
}
