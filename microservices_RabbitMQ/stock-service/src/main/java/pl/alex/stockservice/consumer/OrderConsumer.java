package pl.alex.stockservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.alex.stockservice.dto.OrderEvent;

@Slf4j
@Service
public class OrderConsumer {

    @RabbitListener(queues = "${rabbit.order.queue.name}")
    public void consume(OrderEvent event){
        log.info("OrderEvent received: {}", event.toString());
        // save to database or do some business logic etc.

    }
}
