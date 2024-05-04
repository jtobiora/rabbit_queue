package com.swiftfingers.rabbitmqdemo.controller;


import com.swiftfingers.rabbitmqdemo.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping(value = "/publish")
    public ResponseEntity producer(@RequestParam("message") String message){
        rabbitMQProducer.send(message);

        return ResponseEntity.ok("message sent to RabbitMQ...");
    }

}
