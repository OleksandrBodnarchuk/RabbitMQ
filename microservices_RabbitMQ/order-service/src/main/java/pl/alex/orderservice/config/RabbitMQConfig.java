package pl.alex.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbit.stock.queue.name}")
    private String stockQueueName;

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    @Value("${rabbit.stock.routing.key}")
    private String orderRoutingKey;

    @Value("${rabbit.email.queue.name}")
    private String emailQueueName;

    @Value("${rabbit.email.routing.key}")
    private String emailRoutingKey;


    // create queue
    @Bean
    public Queue queue() {
        return new Queue(stockQueueName);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueueName);
    }

    // create exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    // bind exchange with queue
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(orderRoutingKey);
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(exchange()).with(emailRoutingKey);
    }

    // message converter
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // configure RabbitTemplate
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
