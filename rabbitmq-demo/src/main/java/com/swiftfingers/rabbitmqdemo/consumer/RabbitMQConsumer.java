package com.swiftfingers.rabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {


    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void processMessage(String message) {
        log.info("Received Message: {} ", message);
    }
}
