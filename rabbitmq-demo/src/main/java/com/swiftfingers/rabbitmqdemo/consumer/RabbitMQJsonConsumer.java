package com.swiftfingers.rabbitmqdemo.consumer;

import com.swiftfingers.rabbitmqdemo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.jsonqueue.name}"})
    public void consumeJsonMessage(User user){
        log.info(String.format("Received JSON message -> %s", user.toString()));
    }
}
