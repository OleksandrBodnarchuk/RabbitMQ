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
    @Value("${rabbit.order.queue.name}")
    private String queueName;

    @Value("${rabbit.order.exchange.name")
    private String orderExchange;

    @Value("${rabbit.order.routing.key")
    private String orderRoutingKey;

    // create queue
    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    // create exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(orderExchange);
    }

    // bind exchange with queue
    @Bean
    public Binding binding(TopicExchange topicExchange, Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with(orderRoutingKey);
    }

    // message converter
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    // configure RabbitTemplate
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
