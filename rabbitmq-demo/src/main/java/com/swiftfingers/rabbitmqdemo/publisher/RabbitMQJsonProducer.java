package com.swiftfingers.rabbitmqdemo.publisher;


import com.swiftfingers.rabbitmqdemo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.name}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        log.info("Sending user {} ", user.toString());
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
    }
}
